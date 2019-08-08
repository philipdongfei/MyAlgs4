import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Queue;
import util.Constants;
import util.FileUtil;


public class Ex16_DocumentSimilarity {
    private static class KGramInformation {
        private int frequencyInFile1;
        private int frequencyInFile2;

        KGramInformation(int frequencyInFile1, int frequencyInFile2){
            this.frequencyInFile1 = frequencyInFile1;
            this.frequencyInFile2 = frequencyInFile2;
        }
    }
    private static final int FILE1_ID = 1;
    private static final int FILE2_ID = 2;

    public static double computeKSimilarity(int k, String filename1, String filename2){
        String filePath1 = filename1;//Constants.FILES_PATH + filename1;
        String filePath2 = filename2; //Constants.FILES_PATH + filename2;

        String charactersInFile1 = FileUtil.getAllCharactersFromFile(filePath1, false, false);
        String charactersInFile2 = FileUtil.getAllCharactersFromFile(filePath2, false, false);

        if (charactersInFile1 == null || charactersInFile2 == null){
            return Double.POSITIVE_INFINITY;
        }
        TST<KGramInformation> tst = new TST<>();

        int numberOfKGramsInFile1 = countAndPutKGramsInTST(charactersInFile1, tst, k, FILE1_ID);
        int numberOfKGramsInFile2 = countAndPutKGramsInTST(charactersInFile2, tst, k, FILE2_ID);

        double sumOfDistances = 0;

        for (String key : tst.keys()){
            KGramInformation kGramInformation = tst.get(key);

            double frequency1 = kGramInformation.frequencyInFile1 / (double)numberOfKGramsInFile1;
            double frequency2 = kGramInformation.frequencyInFile2 / (double) numberOfKGramsInFile2;
            sumOfDistances += Math.pow(frequency1 - frequency2, 2);
        }

        return Math.sqrt(sumOfDistances);
    }
    private static int countAndPutKGramsInTST(String wordsInFile, TST<KGramInformation> tst, int k, int fileId){
        int numberOfKGramsInFile = 0;

        for (int word = 0; word <= wordsInFile.length() - k; word++){
            StringBuilder KGram = new StringBuilder();
            numberOfKGramsInFile++;

            for (int currentK = word; currentK < word + k; currentK++){
                KGram.append(wordsInFile.charAt(currentK));
            }
            String kGramValue = KGram.toString();

            if (tst.contains(kGramValue)){
                KGramInformation kGram = tst.get(kGramValue);

                if (fileId == FILE1_ID){
                    kGram.frequencyInFile1++;
                } else if (fileId == FILE2_ID){
                    kGram.frequencyInFile2++;
                }
            } else {
                if (fileId == FILE1_ID){
                    tst.put(kGramValue, new KGramInformation(1, 0));
                } else if (fileId == FILE2_ID){
                    tst.put(kGramValue, new KGramInformation(0, 1));
                }
            }
        }
        return numberOfKGramsInFile;
    }

    public static void main(String[] args){
        int k = Integer.parseInt(args[0]);

        int numberOfFiles = args.length - 1;
        String[] fileNames = new String[numberOfFiles];

        for (int i = 1; i < args.length; i++){
            fileNames[i-1] = args[i];
        }

        double[][] kSimilarityMatrix = new double[numberOfFiles][numberOfFiles];

        for (int file1 = 0; file1 < numberOfFiles; file1++){
            for (int file2 = file1 + 1; file2 < numberOfFiles; file2++){
                double kSimilarity = computeKSimilarity(k, fileNames[file1], fileNames[file2]);

                kSimilarityMatrix[file1][file2] = kSimilarity;
                kSimilarityMatrix[file2][file1] = kSimilarity;
            }
        }
        StdOut.println("K-Similarity matrix");

        for (int file1 = 0; file1 < numberOfFiles; file1++){
            for (int file2 = 0; file2 < numberOfFiles; file2++){
                StdOut.printf("%5.2f ", kSimilarityMatrix[file1][file2]);
            }
            StdOut.println();
        }
    }
}
