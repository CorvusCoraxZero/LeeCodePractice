package AHNU.learning.data_structure;

/*
    寻找最长V串，满足一下条件的数组，即为V形数组：
    · 长度不小于3
    · 在0 < i < arr.length - 1条件下，存在i使得：
        arr[0] > arr[1] >...a[i-1] > a[i]
        arr[i] < arr[i+1] <...<arr[arr.length-1]
    · 索引i两边的项数可以不相等
    给定一个证书组，返回最长的V形连续子数组的长度，没有就返回0

    示例：
        输入：9 //数组长度
             3 2 1 2 1 4 7 5 4
        输出：4
*/

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Transaction {  // testset

    public static void main(String[] args) {
        Gson gson = new Gson();
        HashMap map = gson.fromJson(mapJSON, HashMap.class);
        ArrayList<Map> dateList = gson.fromJson(dateJSON, ArrayList.class);
        HashMap<String, String> result = new HashMap<>();
        for (Map element : dateList) {
            result.put((String)element.get("value"),(String) map.get((String)element.get("name")));
        }
        System.out.println(gson.toJson(result));
    }

    public static String mapJSON = "{\n" +
            "  \n" +
            "      \"Windows 2000\": \"0115\",\n" +
            "      \"Windows\": \"0107\",\n" +
            "      \"HP-UX\": \"0104\",\n" +
            "      \"Linux\": \"0105\",\n" +
            "      \"Suse\": \"0114\",\n" +
            "      \"Oracle Linux (操作系统)\": \"0112\",\n" +
            "      \"AIX\": \"0103\",\n" +
            "      \"Solaris\": \"0106\",\n" +
            "      \"Debian\": \"0109\",\n" +
            "      \"VMware vCenter\": \"0120\",\n" +
            "      \"Hyper-V\": \"0117\",\n" +
            "      \"VMware ESXi\": \"0119\",\n" +
            "      \"OpenStack\": \"0118\",\n" +
            "      \"XenServer\": \"0122\",\n" +
            "      \"Xen\": \"0121\",\n" +
            "      \"LinkTrust Firewall\": \"0067\",\n" +
            "      \"DPtech NF\": \"0068\",\n" +
            "      \"Fortigate\": \"0069\",\n" +
            "      \"Hillstone Firewall\": \"0070\",\n" +
            "      \"DPtech Firewall\": \"0071\",\n" +
            "      \"Cisco Router\": \"0072\",\n" +
            "      \"Cisco 三层交换机\": \"0073\",\n" +
            "      \"Cisco PIX Firewall\": \"0074\",\n" +
            "      \"DPtech IDS\": \"0075\",\n" +
            "      \"NetScreen\": \"0076\",\n" +
            "      \"DPtech IPS\": \"0077\",\n" +
            "      \"Ruijie Switch\": \"0078\",\n" +
            "      \"Huawei Firewall\": \"0079\",\n" +
            "      \"Maipu Router\": \"0080\",\n" +
            "      \"Cisco ASA Firewall\": \"0081\",\n" +
            "      \"Cisco 二层交换机\": \"0082\",\n" +
            "      \"Juniper Router\": \"0083\",\n" +
            "      \"Maipu Switch\": \"0087\",\n" +
            "      \"Topsec IDS\": \"0088\",\n" +
            "      \"Ruijie Router\": \"0089\",\n" +
            "      \"H3C IDS\": \"0090\",\n" +
            "      \"H3C 二层交换机\": \"0092\",\n" +
            "      \"DPtech WAF\": \"0094\",\n" +
            "      \"Topsec IPS\": \"0095\",\n" +
            "      \"CheckPoint\": \"0096\",\n" +
            "      \"H3C Router\": \"0097\",\n" +
            "      \"H3C 三层交换机\": \"0098\",\n" +
            "      \"Juniper Firewall (SRX-series)\": \"0099\",\n" +
            "      \"H3C IPS\": \"0100\",\n" +
            "      \"SQL Server\": \"0054\",\n" +
            "      \"DB2 Windows\": \"0057\",\n" +
            "      \"DB2 Linux\": \"0056\",\n" +
            "      \"DB2 AIX\": \"0055\",\n" +
            "      \"Informix Solaris\": \"0060\",\n" +
            "      \"Informix AIX\": \"0058\",\n" +
            "      \"Informix Linux\": \"0059\",\n" +
            "      \"Oracle AIX\": \"0063\",\n" +
            "      \"Oracle Linux\": \"0052\",\n" +
            "      \"Oracle Windows\": \"0065\",\n" +
            "      \"Oracle Linux (数据库)\": \"0064\",\n" +
            "      \"MySQL Linux\": \"0050\",\n" +
            "      \"MySQL Windows\": \"0062\",\n" +
            "      \"Sybase Linux\": \"0123\",\n" +
            "      \"Sybase Windows\": \"0124\",\n" +
            "      \"MongoDB Linux\": \"0125\",\n" +
            "      \"MongoDB Windows\": \"0126\",\n" +
            "      \"Redis Linux\": \"0127\",\n" +
            "      \"Redis Windows\": \"0128\",\n" +
            "      \"Apache Windows\": \"0002\",\n" +
            "      \"Jboss 4,5 Linux\": \"0007\",\n" +
            "      \"IIS7.0 8.0 Windows 2008\": \"0029\",\n" +
            "      \"BIND Windows\": \"0023\",\n" +
            "      \"WebLogic Windows\": \"0016\",\n" +
            "      \"WebSphere Windows\": \"0049\",\n" +
            "      \"Domino Windows\": \"0025\",\n" +
            "      \"Jboss 6 Windows\": \"0009\",\n" +
            "      \"Nginx Windows\": \"0035\",\n" +
            "      \"Tongweb5.0 Windows\": \"0042\",\n" +
            "      \"Tomcat Windows\": \"0011\",\n" +
            "      \"IIS7.0 Windows 2008\": \"0005\",\n" +
            "      \"IIS5.0 Windows 2000\": \"0003\",\n" +
            "      \"IIS6.0 Windows 2003\": \"0004\",\n" +
            "      \"Exchange 2016\": \"0026\",\n" +
            "      \"Resin Windows\": \"0037\",\n" +
            "      \"Tomcat Linux\": \"0010\",\n" +
            "      \"TongWeb5.0 Linux\": \"0041\",\n" +
            "      \"IHS Linux\": \"0027\",\n" +
            "      \"BIND Linux\": \"0022\",\n" +
            "      \"WebLogic Oracle Linux\": \"0045\",\n" +
            "      \"Jboss 6 Linux\": \"0032\",\n" +
            "      \"WebLogic AIX\": \"0043\",\n" +
            "      \"WebSphere AIX\": \"0017\",\n" +
            "      \"WebSphere Linux\": \"0048\",\n" +
            "      \"Apache Linux\": \"0001\",\n" +
            "      \"TongWeb4.6 Linux\": \"0040\",\n" +
            "      \"WebLogic Linux\": \"0044\",\n" +
            "      \"Jboss 4:5 Linux\": \"0006\",\n" +
            "      \"Nginx Linux\": \"0034\",\n" +
            "      \"Resin Linux\": \"0036\",\n" +
            "      \"Domino Linux\": \"0024\",\n" +
            "      \"Oracle\": \"9100101\",\n" +
            "      \"Postgresql\": \"9100102\",\n" +
            "      \"Kingbase\": \"9100103\",\n" +
            "      \"Informix\": \"9100104\",\n" +
            "      \"Sybase\": \"9100105\",\n" +
            "      \"DB2_V9/10\": \"9100106\",\n" +
            "      \"DB2_V8\": \"9100107\",\n" +
            "      \"MySQL\": \"9100108\",\n" +
            "      \"SQL_Server_2005/2008\": \"9100109\",\n" +
            "      \"SQL_Server_2000\": \"9100110\",\n" +
            "      \"DaMeng\": \"9100111\"\n" +
            "}";

    public static String dateJSON = " [\n" +
            "    {\n" +
            "        \"name\": \"Windows 2000\",\n" +
            "        \"value\": \"0115\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Windows\",\n" +
            "        \"value\": \"0107\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Windows\",\n" +
            "        \"value\": \"0116\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"HP-UX\",\n" +
            "        \"value\": \"0104\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"HP-UX\",\n" +
            "        \"value\": \"0110\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Linux\",\n" +
            "        \"value\": \"0105\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Suse\",\n" +
            "        \"value\": \"0114\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Oracle Linux (操作系统)\",\n" +
            "        \"value\": \"0112\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Linux\",\n" +
            "        \"value\": \"0111\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"AIX\",\n" +
            "        \"value\": \"0103\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Solaris\",\n" +
            "        \"value\": \"0106\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Solaris\",\n" +
            "        \"value\": \"0113\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"AIX\",\n" +
            "        \"value\": \"0108\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Debian\",\n" +
            "        \"value\": \"0109\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"VMware vCenter\",\n" +
            "        \"value\": \"0120\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Hyper-V\",\n" +
            "        \"value\": \"0117\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"VMware ESXi\",\n" +
            "        \"value\": \"0119\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"OpenStack\",\n" +
            "        \"value\": \"0118\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"XenServer\",\n" +
            "        \"value\": \"0122\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Xen\",\n" +
            "        \"value\": \"0121\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"SQL Server\",\n" +
            "        \"value\": \"0054\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Oracle Windows\",\n" +
            "        \"value\": \"0065\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Oracle Windows\",\n" +
            "        \"value\": \"0053\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"MySQL Windows\",\n" +
            "        \"value\": \"0062\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"MySQL Windows\",\n" +
            "        \"value\": \"0051\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DB2 Windows\",\n" +
            "        \"value\": \"0057\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"SQL Server\",\n" +
            "        \"value\": \"0066\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Oracle Linux (数据库)\",\n" +
            "        \"value\": \"0064\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Informix Solaris\",\n" +
            "        \"value\": \"0060\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Informix Linux\",\n" +
            "        \"value\": \"0059\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Oracle AIX\",\n" +
            "        \"value\": \"0063\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Informix AIX\",\n" +
            "        \"value\": \"0058\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"MySQL Linux\",\n" +
            "        \"value\": \"0050\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"MySQL Linux\",\n" +
            "        \"value\": \"0061\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DB2 Linux\",\n" +
            "        \"value\": \"0056\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DB2 AIX\",\n" +
            "        \"value\": \"0055\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Oracle Linux\",\n" +
            "        \"value\": \"0052\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Sybase Linux\",\n" +
            "        \"value\": \"0123\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Sybase Windows\",\n" +
            "        \"value\": \"0124\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"MongoDB Linux\",\n" +
            "        \"value\": \"0125\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"MongoDB Windows\",\n" +
            "        \"value\": \"0126\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Redis Linux\",\n" +
            "        \"value\": \"0127\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Redis Windows\",\n" +
            "        \"value\": \"0128\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Apache Windows\",\n" +
            "        \"value\": \"0002\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Apache Windows\",\n" +
            "        \"value\": \"0021\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 4,5 Windows\",\n" +
            "        \"value\": \"0007\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"IIS7.0 8.0 Windows 2008\",\n" +
            "        \"value\": \"0029\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"BIND Windows\",\n" +
            "        \"value\": \"0023\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebLogic Windows\",\n" +
            "        \"value\": \"0016\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebSphere Windows\",\n" +
            "        \"value\": \"0049\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebSphere Windows\",\n" +
            "        \"value\": \"0019\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Domino Windows\",\n" +
            "        \"value\": \"0025\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 6 Windows\",\n" +
            "        \"value\": \"0009\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Nginx Windows\",\n" +
            "        \"value\": \"0035\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tongweb5.0 Windows\",\n" +
            "        \"value\": \"0042\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 6 Windows\",\n" +
            "        \"value\": \"0033\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tomcat Windows\",\n" +
            "        \"value\": \"0011\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"IIS7.0 Windows 2008\",\n" +
            "        \"value\": \"0005\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"IIS5.0 Windows 2000\",\n" +
            "        \"value\": \"0003\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tomcat Windows\",\n" +
            "        \"value\": \"0039\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebLogic Windows\",\n" +
            "        \"value\": \"0046\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 4,5 Windows\",\n" +
            "        \"value\": \"0031\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"IIS6.0 Windows 2003\",\n" +
            "        \"value\": \"0004\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Exchange 2016\",\n" +
            "        \"value\": \"0026\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Resin Windows\",\n" +
            "        \"value\": \"0037\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tongweb5.0 Windows\",\n" +
            "        \"value\": \"0014\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"IIS6.0 Windows 2003\",\n" +
            "        \"value\": \"0028\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tomcat Linux\",\n" +
            "        \"value\": \"0010\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"TongWeb5.0 Linux\",\n" +
            "        \"value\": \"0041\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"IHS Linux\",\n" +
            "        \"value\": \"0027\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"BIND Linux\",\n" +
            "        \"value\": \"0022\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebLogic Oracle Linux\",\n" +
            "        \"value\": \"0045\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 6 Linux\",\n" +
            "        \"value\": \"0032\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebLogic AIX\",\n" +
            "        \"value\": \"0043\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebSphere AIX\",\n" +
            "        \"value\": \"0017\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebSphere Linux\",\n" +
            "        \"value\": \"0048\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Apache Linux\",\n" +
            "        \"value\": \"0001\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"TongWeb4.6 Linux\",\n" +
            "        \"value\": \"0040\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebLogic Linux\",\n" +
            "        \"value\": \"0044\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebSphere Linux\",\n" +
            "        \"value\": \"0018\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebLogic Linux\",\n" +
            "        \"value\": \"0015\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"WebSphere AIX\",\n" +
            "        \"value\": \"0047\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Apache Linux\",\n" +
            "        \"value\": \"0020\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 4,5 Linux\",\n" +
            "        \"value\": \"0006\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 4,5 Linux\",\n" +
            "        \"value\": \"0030\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Nginx Linux\",\n" +
            "        \"value\": \"0034\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"TongWeb5.0 Linux\",\n" +
            "        \"value\": \"0013\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"TongWeb4.6 Linux\",\n" +
            "        \"value\": \"0012\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Tomcat Linux\",\n" +
            "        \"value\": \"0038\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Resin Linux\",\n" +
            "        \"value\": \"0036\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Domino Linux\",\n" +
            "        \"value\": \"0024\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Jboss 6 Linux\",\n" +
            "        \"value\": \"0008\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"LinkTrust Firewall\",\n" +
            "        \"value\": \"0067\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DPtech NF\",\n" +
            "        \"value\": \"0068\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Fortigate\",\n" +
            "        \"value\": \"0069\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Hillstone Firewall\",\n" +
            "        \"value\": \"0070\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DPtech Firewall\",\n" +
            "        \"value\": \"0071\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco Router\",\n" +
            "        \"value\": \"0072\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco 三层交换机\",\n" +
            "        \"value\": \"0073\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco PIX Firewall\",\n" +
            "        \"value\": \"0074\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DPtech IDS\",\n" +
            "        \"value\": \"0075\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"NetScreen\",\n" +
            "        \"value\": \"0076\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DPtech IPS\",\n" +
            "        \"value\": \"0077\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Ruijie Switch\",\n" +
            "        \"value\": \"0078\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Huawei Firewall\",\n" +
            "        \"value\": \"0079\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Maipu Router\",\n" +
            "        \"value\": \"0080\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco ASA Firewall\",\n" +
            "        \"value\": \"0081\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco 二层交换机\",\n" +
            "        \"value\": \"0082\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Juniper Router\",\n" +
            "        \"value\": \"0083\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco PIX Firewall\",\n" +
            "        \"value\": \"0084\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco 三层交换机\",\n" +
            "        \"value\": \"0085\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Huawei Firewall\",\n" +
            "        \"value\": \"0086\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Maipu Switch\",\n" +
            "        \"value\": \"0087\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Topsec IDS\",\n" +
            "        \"value\": \"0088\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Ruijie Router\",\n" +
            "        \"value\": \"0089\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"H3C IDS\",\n" +
            "        \"value\": \"0090\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"NetScreen\",\n" +
            "        \"value\": \"0091\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"H3C 二层交换机\",\n" +
            "        \"value\": \"0092\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Juniper Router\",\n" +
            "        \"value\": \"0093\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"DPtech WAF\",\n" +
            "        \"value\": \"0094\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Topsec IPS\",\n" +
            "        \"value\": \"0095\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"CheckPoint\",\n" +
            "        \"value\": \"0096\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"H3C Router\",\n" +
            "        \"value\": \"0097\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"H3C 三层交换机\",\n" +
            "        \"value\": \"0098\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Juniper Firewall (SRX-series)\",\n" +
            "        \"value\": \"0099\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"H3C IPS\",\n" +
            "        \"value\": \"0100\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco Router\",\n" +
            "        \"value\": \"0101\"\n" +
            "    },\n" +
            "    {\n" +
            "        \"name\": \"Cisco 二层交换机\",\n" +
            "        \"value\": \"0102\"\n" +
            "    }\n" +
            "]\n";
}



