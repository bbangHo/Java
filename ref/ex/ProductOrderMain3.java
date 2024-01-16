package ref.ex;

import java.util.Scanner;

public class ProductOrderMain3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("입력할 주문의 개수를 입력하세요: ");
        int n = scanner.nextInt(); //1 입력하고 엔터누르면 1만 받고 엔터(\n)은 입력 못 받고 넘어 가짐
        scanner.nextLine();//그래서 엔터(\n) 문자 입력 받기 위해서 문자열 입력 한 번더 받아줌(그 다음에 nextLine 받을 때 바로 엔터 쳐지는)

        ProductOrder [] orders = new ProductOrder[n];

        for(int i = 0; i <n; i++){
            System.out.println((i+1)+"번째 주문 정보를 입력하세요.");

            System.out.print("상품명: ");
            String productName = scanner.nextLine();

            System.out.print("가격: ");
            int price = scanner.nextInt();

            System.out.print("수량: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();//남겨진 엔터 받기 위한 코드

            orders[i] = createOrder(productName, price, quantity);
        }

        printOrders(orders);
        int totalAmount = getTotalAmount(orders);
        System.out.println("총 결제 금액: "+ totalAmount);


    }

    static ProductOrder createOrder(String productName, int price, int quantity){
        ProductOrder order = new ProductOrder();
        order.productName = productName;
        order.price = price;
        order.quantity = quantity;
        return order;
    }

    static void printOrders(ProductOrder[] orders){
        for(ProductOrder order : orders)
            System.out.println("상품명: " + order.productName + ",가격: "+ order.price + ", 수량: " + order.quantity);
    }

    static int getTotalAmount(ProductOrder[] orders){
        int totalAmount = 0;
        for(ProductOrder order : orders)
            totalAmount += order.price*order.quantity;

        return totalAmount;
    }
}
