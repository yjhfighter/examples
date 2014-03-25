package org.beyondpn.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author beyondpn
 *         Create: 14-3-17 下午4:18
 */
public class GrepMatchRoleId {

    public static void main(String... args) throws IOException {

        String filePath = "C:\\Users\\yangjianhua\\Documents\\Tencent Files\\276188297\\FileRecv\\consumer1_gameserver.log.2014-03-16-15.log";

        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath), StandardCharsets.UTF_8)) {
            int error = 0;

            Map<Integer, String> threadMap = new HashMap<>();
            for (String line = null; (line = br.readLine()) != null; ) {
                if (!line.startsWith("2014")) {
                    continue;
                }
                String[] arr = line.split(" ");
                String threadId = arr[3];
                if (threadId.contains("mainContainer") && line.contains("MatchAutoFightMessageListener")) {
                    int idx1 = threadId.indexOf("-");
                    int idx2 = threadId.indexOf(">");
                    int thread = Integer.parseInt(threadId.substring(idx1 + 1, idx2));

                    if (line.contains("开始")) {
                        String lastLine = threadMap.get(thread);
                        if (lastLine != null) {
                            if(!lastLine.contains("结束")){
//                                System.out.println(lastLine);
                                String roleId = lastLine.substring(lastLine.indexOf("[")+1,lastLine.indexOf("]"));
                                System.out.println(String.format("insert into test(roleId) values ('%s');",roleId));
                                error++;
                            }
                        }
                        threadMap.put(thread, line);
                    } else if (line.contains("结束")) {
                        threadMap.put(thread, line);
                    }

                }
            }

            System.out.println("error count" + error);
        }
    }

}
