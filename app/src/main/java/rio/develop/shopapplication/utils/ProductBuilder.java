package rio.develop.shopapplication.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UnknownFormatFlagsException;

import rio.develop.shopapplication.data.Order;
import rio.develop.shopapplication.data.ProductDto;

public class ProductBuilder {


    public int updateProducts() {
        /*
         * Save suppler`s data to OriginalProduct table
         * */
        parseJsonToProducts();

        /*
         * Process today updated supplier`s OriginalProducts to Products for site output
         * */


        mapProducts();

        /*
         *
         * */
        return result();
    }

    private int result() {
        return 0;
    }


    private void mapProducts() {
        for (OriginalProduct originalProduct : originalProducts) {
            try {
                if (originalProduct.notInStock() && productNotExists(originalProduct)) {
                    /*Разметить главные параметры для Product из заданного json файла-разметки*/
                    Product product = mapProductCore(originalProduct);

                    /*Разметить операционные данные Product*/
                    if (product != null) {
                        resolveProductsDetails(originalProduct, product);
                    }
                    else {
                        log.warn("Product match failed for: {}", originalProduct.toString());
                    }
                }
                else {
                    updateProduct(originalProduct);
                }

            } catch (FileNotFoundException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    private void parseJsonToProducts() {
        try {
            for (MultipartFile excelFile : supplierCatalogs) {
                if (excelFile != null) {

                    System.out.println("Парсинг: " + excelFile.getOriginalFilename());

                    try (XSSFWorkbook workbook = new XSSFWorkbook(excelFile.getInputStream())) {
                        XSSFSheet sheet = workbook.getSheetAt(0);

                        int countCreate = 0, countUpdate = 0;
                        boolean supplierRBT;

                        try {
                            supplierRBT = Objects.requireNonNull(excelFile.getOriginalFilename()).contains("Opt Chel");
                        }
                        catch (NullPointerException e) {
                            log.error("NullPointerException in parseToOriginalProducts", e);
                            continue;
                        }

                        /*
                         * Для каждой строки товара в таблице
                         * */
                        for (Row originalProductRow : sheet) {
                            if (originalProductRowIsCorrect(originalProductRow, supplierRBT)) {
                                String productID = resolveProductID(supplierRBT, originalProductRow);

                                /*Обновить существущий OriginalProduct*/
                                if (originalProductExists(productID)) {
                                    updateOriginalProduct(originalProductRow, productID, supplierRBT);
                                    countUpdate++;
                                }
                                /*Создать OriginalProduct*/
                                else {
                                    createOriginalProduct(originalProductRow, productID, supplierRBT);
                                    countCreate++;
                                }
                            }
                        }
                        System.out.println("Всего строк в файле: " + sheet.getLastRowNum());
                        System.out.println("Создано: " + countCreate);
                        System.out.println("Обновлено: " + countUpdate);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        catch (OLE2NotOfficeXmlFileException e) {
            /**/
            System.out.println("Формат Excel документа должен быть XLSX!");
            throw new UnknownFormatFlagsException("Формат Excel документа должен быть XLSX");
        }
    }



    public LinkedList<Object> filterProducts(LinkedHashMap<String, String> filters, String group, Pageable pageable) {
        /*
        switch(filterKey) {
            case "Smart TV"
                if group.equals"TV" return SmartTV
        */

        List<ProductDto> products;
        String inStockFilter = filters.get("stock");

        if (inStockFilter.equals("All")) {
            products = productRepo.findByAvailableTrueAndProductGroupIgnoreCase(group);
        }
        else {
            products = productRepo.findByAvailableTrueAndProductGroupIgnoreCaseAndProductInStockTrue(group);
            ///List<Product> products = productRepo.findProductsByProductGroupIgnoreCaseAndInStockCityEquals(group, city);

        }
        /*Отфильтровать products по выбраным фильтрам*/
        for (Map.Entry<String, String> filterPair : filters.entrySet()) {
            products = filteringProducts(products, filterPair);
        }

        /*Создать список доступных фильтров для текущей модели фильтрации*/
        String filterCheckList = createComputedFilterChecklist(products);

        products.sort(Comparator.comparing(Product::getPic).thenComparingInt(Product::getFinalPrice));
        /// products.sort(Comparator.comparing(Product::getFinalPrice).thenComparing(Product::getPic));

        return productsPage(products, pageable, filterCheckList);
    }

    public Order addProductToOrder(String productID, User user) {
        productID = productID.replaceAll("=","");

        ProductDto product = getProduct(productID);
        Order order = getActiveOrder(user);
        order.getOrderedProducts().put(productID, 1);
        order.setTotalPrice(order.getTotalPrice() + product.getFinalPrice());
        order.setTotalBonus(order.getTotalBonus() + product.getBonus());
        orderRepo.save(order);
        return order;
    }

    private int result() {
        return ;
    }

}
