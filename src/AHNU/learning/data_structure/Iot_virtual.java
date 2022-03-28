package AHNU.learning.data_structure;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Iot_virtual {

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("配置读取中...");
        System.out.println("连接云平台...");
        System.out.println("虚拟设备 - CoAP已上线");
        System.out.println("ip：10.20.84.81");
        System.out.println("--------------------------------------");
        System.out.println("请输入传输的信息：");
        Scanner scanner = new Scanner(System.in);
        // new ArrayList<>()
        while (true){
            scanner.next(); // {"Car_number":"鄂N20348","Brake_state":1,"Pic_name":"xxxx","Brake_control":"open","Display":"业主车辆，鄂N20348，欢迎回家。"}
            System.out.println("收到云平台确认消息：\"code\":200,\"data\":{},\"id\":\"1644924820428\",\"message\":\"success\",\"method\":\"thing.event.property.post\",\"version\":\"1.0\"");
        }
    }


}



