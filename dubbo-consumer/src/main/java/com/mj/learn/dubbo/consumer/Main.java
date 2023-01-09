package com.mj.learn.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
@EnableDubbo
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

//    public static void main2(String[] args) {
//        List<String> sourceIps = new ArrayList<>() {{
//            this.add("172.192.108.210");
//            this.add("172.82.127.47");
//            this.add("172.159.250.138");
//            this.add("172.148.113.111");
//            this.add("172.140.133.163");
//            this.add("172.159.194.83");
//            this.add("172.155.111.133");
//        }};
//        List<String> targetIps = new ArrayList<>() {{
//            this.add("172.148.113.111");
//            this.add("172.140.133.163");
//            this.add("172.159.194.83");
//            this.add("172.155.111.133");
//            this.add("172.192.108.210");
//            this.add("172.82.127.47");
//            this.add("172.159.250.138");
//        }};
//        List<Integer> num = new ArrayList<>() {{
//            this.add(1000);
//            this.add(1200);
//            this.add(1500);
//            this.add(5523);
//            this.add(3500);
//            this.add(3200);
//        }};
//        int numIndex = 0;
//
//        for (String sourceIp : sourceIps) {
//            for (String targetIp : targetIps) {
//                if (sourceIp.equals(targetIp)) {
//                    continue;
//                }
//                String xx = "curl --location --request GET 'http://127.0.0.1:8001/api/mp/cscene/monitor/flow/simulation?" +
//                        "destinationIp=" + targetIp + "&destinationMacs=fa:16:3e:38:d8:6c&sceneId=2a73e9c50370424689da402decf962c2&nodeIds=008bb2db-174f-490e-9da7-0d935678ea89&sourceIp=" + sourceIp
//                        + "&sourceMacs=fa:16:3e:38:d8:6c&shuffleCategory=true&networkBytes=" + num.get(numIndex) + "'" +
//                        " --header 'clientSecret: 2112f4b855264ad7b1a4209737fc7836'" +
//                        " --header 'clientId: 84261d495c414e'";
//                numIndex = (numIndex + 1) % num.size();
//                System.out.println(xx);
//            }
//        }
//
//    }
//
//    public static void main(String[] args) {
//        String x = "192.168.1.1";
//        System.out.println(x.split("/")[0]);
//    }
}
