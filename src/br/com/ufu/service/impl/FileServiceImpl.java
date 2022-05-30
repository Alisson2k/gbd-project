package br.com.ufu.service.impl;

import br.com.ufu.config.Constants;
import br.com.ufu.service.FileService;
import br.com.ufu.util.UtilRandom;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class FileServiceImpl implements FileService {

    @Override
    public Object createHeapFile(String fileName) {
        String entirePath = System.getProperty("user.dir") + "/" + fileName;
        if (Constants.FORCED || !exists(entirePath)) {
            System.out.println("Creating file in path: " + entirePath);
            populateFile(entirePath);
        }

        createHeap(fileName, "heapfile");
        return null;
    }

    private Boolean exists(String fileName) {
        try {
            return new File(fileName).exists();
        } catch (Exception e) {
            System.out.println("File cannot be available, trying to creating another then");
        }
        return false;
    }

    private void populateFile(String filePath) {
        try {
            FileWriter output = new FileWriter(filePath);

            for (int i = 1; i < Constants.PAGE_COUNT * Constants.PAGE_SIZE; i++) {
                output.write(UtilRandom.randomStudent(i).toString());
                output.write("\n");
            }
            output.close();
        } catch(Exception e) {
            e.getStackTrace();
        }
    }

    private void createHeap(String filePath, String heapFileName) {
        File heapFile = new File(heapFileName);
        FileOutputStream output;
        BufferedReader bufferedReader;
        String line;
        int outCount = 0;
        int recordSize = Constants.PAGE_SIZE * Constants.PAGE_COUNT;
        byte[] record = new byte[recordSize];

        try {
            output = new FileOutputStream(heapFile);
            bufferedReader = new BufferedReader(new FileReader(filePath));

            while ((line = bufferedReader.readLine()) != null) {
                String[] entry = line.split(",", -1);
                byte[] rid = getRid(outCount);
                System.arraycopy(rid, 0, record, 0, rid.length);
                copy(entry[0], entry[0].length(), 20, record);
                copy(entry[1], 43, 15, record);
                copy(entry[2], 20, 20, record);

                outCount++;
                output.write(record);

//                if ((outCount+1) * recordSize > Constants.PAGE_SIZE) {
//                    eofByteAddOn(fos, pagesize, outCount, pageCount);
//
//                    outCount = 0;
//                    pageCount++;
//                }
//                recCount++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private byte[] getRid(int out) {
        ByteBuffer bBuffer = ByteBuffer.allocate(4);
        bBuffer.putInt(out);
        return bBuffer.array();
    }

    private void copy(String entry, int SIZE, int DATA_OFFSET, byte[] rec) {
        byte[] DATA = new byte[SIZE];
        byte[] DATA_SRC = entry.trim().getBytes(StandardCharsets.UTF_8);
        if (!entry.equals("")) {
            System.arraycopy(DATA_SRC, 0, DATA,     0, DATA_SRC.length);
        }
        System.arraycopy(DATA, 0, rec, DATA_OFFSET, DATA.length);
    }

    @Override
    public InputStream readFile(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }
}
