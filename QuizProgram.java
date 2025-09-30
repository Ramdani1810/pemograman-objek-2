import java.util.*;

public class QuizProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Soal dan Jawaban
        String[][] soalJawaban = {
            {"Apa ibu kota Indonesia?", "jakarta"},
            {"Berapakah hasil dari 5 + 3?", "8"},
            {"Siapa presiden pertama Indonesia?", "soekarno"},
            {"Warna bendera Indonesia bagian atas?", "merah"},
            {"Nama planet ketiga dari matahari?", "bumi"},
            {"Apa lambang negara Indonesia?", "garuda"},
            {"Bahasa resmi Indonesia?", "indonesia"},
            {"Jumlah provinsi di Indonesia (2023)?", "38"}
        };

        // Acak soal
        List<Integer> indeks = new ArrayList<>();
        for (int i = 0; i < soalJawaban.length; i++) {
            indeks.add(i);
        }
        Collections.shuffle(indeks);

        int skor = 0;

        // Tampilkan 5 soal
        for (int i = 0; i < 5; i++) {
            int idx = indeks.get(i);
            System.out.println("Soal " + (i + 1) + ": " + soalJawaban[idx][0]);
            System.out.print("Jawaban: ");
            String jawabanUser = scanner.nextLine().trim().toLowerCase();

            if (jawabanUser.equals(soalJawaban[idx][1])) {
                System.out.println("✅ Benar!\n");
                skor++;
            } else {
                System.out.println("❌ Salah. Jawaban yang benar: " + soalJawaban[idx][1] + "\n");
            }
        }

        System.out.println("Skor Anda: " + skor + " dari 5");
        scanner.close();
    }
}
