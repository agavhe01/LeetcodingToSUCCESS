import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class LogProcessor {
    public static void main(String[] args) {
            String inputFileName = "hosts_access_log";
            String outputFileName = "bytes_hosts_access_log.txt";

            List < String > filteredRecords = new ArrayList < > ();

            try (BufferedReader br = new BufferedReader(new FileReader(inputFileName)) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        if (line.contains("\"GET") && line.endsWith("\"")) {
                            String[] parts = line.split(" ");
                            if (parts.length >= 10) {
                                int bytes = Integer.parseInt(parts[parts.length - 1]);
                                if (bytes > 5000) {
                                    filteredRecords.add(line);
                                }
                            }
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Collections.sort(filteredRecords, (record1, record2) - > {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss");
                    try {
                        Date date1 = dateFormat.parse(record1.split(" ")[3].substring(1));
                        Date date2 = dateFormat.parse(record2.split(" ")[3].substring(1));
                        return date1.compareTo(date2);
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0;
                    }
                });

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName)) {
                        for (String record: filteredRecords) {
                            bw.write(record);
                            bw.newLine();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }