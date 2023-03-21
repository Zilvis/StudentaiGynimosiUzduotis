import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Studentai | Gynimosi uzduotis");
        StudentasImpl s1 = new StudentasImpl("Kazlauskas Jonas","1992 06 11",7.2);
        StudentasImpl s2 = new StudentasImpl("Grazulis Petras","1998 06 11",3.2);
        StudentasImpl s3 = new StudentasImpl("Kuze Ona","1999 06 11",9.1);
        StudentasImpl s4 = new StudentasImpl("Baumila Mantas","1997 06 11",8.2);
        StudentasImpl s5 = new StudentasImpl("Ostapenko Petras","1991 06 11",4.2);
        StudentasImpl s6 = new StudentasImpl("Virsila Erikas","2000 06 11",5.1);
        StudentasImpl s7 = new StudentasImpl("Nainiene Erika","2002 06 11",7.2);
        StudentasImpl s8 = new StudentasImpl("Pundzius Tomas","2003 06 11",6.6);
        StudentasImpl s9 = new StudentasImpl("Adomaitis Gintaras","2005 06 11",5.6);
        StudentasImpl s10 = new StudentasImpl("Ersketa Tomas","2006 06 11",2.2);

        LinkedList <StudentasImpl> sarasas = new LinkedList<StudentasImpl>();
        sarasas.add(s1); sarasas.add(s2); sarasas.add(s3); sarasas.add(s4); sarasas.add(s5);
        sarasas.add(s6); sarasas.add(s7); sarasas.add(s8); sarasas.add(s9); sarasas.add(s10);

        StudentasImpl s = new StudentasImpl();


        System.out.println("Pasirinkite ka norite daryti:");
        System.out.println("" +
                "1. Isvesti visus studentus\n" +
                "2. Studentu skaicius pagal grupe\n" +
                "3. Studentai pagal pazanguma\n" +
                "4. Patikrinti kurie studentai turi neigiama vidurki\n" +
                "5. Sukeisti studentu vidurkius\n" +
                "6. Studentu paieska pagal metus arba varda pavarde\n");
        Scanner scanner = new Scanner(System.in);
        int pasirinkimas = scanner.nextInt();

        switch (pasirinkimas){
            case 1:
                spauzdintiSarasa(sarasas);
                break;
            case 2:
                studentuSarasasPagalGrupe(sarasas);
                break;
            case 3:
                Collections.sort(sarasas);
                spauzdintiSarasa(sarasas);
                break;
            case 4:
                pasalinaPrastaiBesimokancius(sarasas,5);
                break;
            case 5:
                SukeistiStudentuVidurki(sarasas);
                break;
            case 6:
                studentuPaieska(sarasas);
                break;
            default:
                System.out.println("Pasirinkite ka norite daryti:");
        }
    }

    static void spauzdintiSarasa(LinkedList<StudentasImpl> sarasas){
        sarasas.forEach(studentas ->
                System.out.println(studentas));
    }

    static void SukeistiStudentuVidurki (LinkedList<StudentasImpl> sarasas){
        double max = Collections.min(sarasas).getVidurkis();
        double min = Collections.max(sarasas).getVidurkis();

        for (StudentasImpl studentas : sarasas){
            if (studentas.getVidurkis() == max){
                studentas.setVidurkis(max);
            }
            if (studentas.getVidurkis() == min){
                studentas.setVidurkis(min);
            }
        }
        spauzdintiSarasa(sarasas);
    }

    static void studentuSarasasPagalGrupe(LinkedList<StudentasImpl> sarasas){
        System.out.println("Studentu paieska pagal grupe");
        Scanner scanner = new Scanner(System.in);
        String raktazodis = scanner.next();
        int count = 0;
        Iterator<StudentasImpl> i = sarasas.iterator();
        while(i.hasNext()){
            StudentasImpl studentas = i.next();
            if(studentas.getGrupe().equalsIgnoreCase(raktazodis)){
                System.out.println(studentas);
                count++;
            }
        }
        System.out.println("Viso rasta "+count+" studentu");
    }

    static void studentuPaieska(LinkedList<StudentasImpl> sarasas){
        System.out.println("Studentu paieska: ( Iveskite Varda pavarde arba gimimo metus )");
        Scanner scanner = new Scanner(System.in);
        String raktazodis = scanner.next();
        int count = 0;
        Iterator<StudentasImpl> i = sarasas.iterator();
        while(i.hasNext()){
            StudentasImpl studentas = i.next();
            if(studentas.getPavardeVardas().toLowerCase().contains(raktazodis.toLowerCase()) || studentas.getGimimoMetai().contains(raktazodis)){
                System.out.println(studentas);
                count++;
            }
        }
        System.out.println("Viso rasta "+count+" studentu");
    }

    static void pasalinaPrastaiBesimokancius (LinkedList<StudentasImpl> sarasas, int vidurkis){
        int count = 0;
        Iterator<StudentasImpl> i = sarasas.iterator();
        while (i.hasNext()){
            StudentasImpl studentas = i.next();
            if (studentas.getVidurkis() < vidurkis) {
                i.remove(); count++;
            }
        }
        System.out.println("Mokiniai su teigiamu vidurkiu:");
        spauzdintiSarasa(sarasas);
        System.out.println("Viso neigiamus vidurkius turi " + count+ " studentai");
    }
}