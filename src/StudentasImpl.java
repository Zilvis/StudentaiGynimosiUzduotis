import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class StudentasImpl implements Comparable<StudentasImpl>{
    private int pazymejimoNumeris;
    private String pavardeVardas;
    private String gimimoMetai;
    private String grupe;
    private double vidurkis;

    Random random = new Random();
    StudentasImpl (){}

    StudentasImpl (String pavardeVardas, String gimimoMetai, double vidurkis){
        this.pazymejimoNumeris = random.nextInt(1000);
        this.pavardeVardas = pavardeVardas;
        this.gimimoMetai = gimimoMetai;
        this.grupe = getRandomGrupe();
        this.vidurkis = vidurkis;
    }

    public void setPazymejimoNumeris (int pazymejimoNumeris){
        this.pazymejimoNumeris = pazymejimoNumeris;
    }
    public int getPazymejimoNumeris(){
        return pazymejimoNumeris;
    }
    public void setPavardeVardas (String pavardeVardas){
        this.pavardeVardas = pavardeVardas;
    }
    public String getPavardeVardas(){
        return pavardeVardas;
    }
    public void setGimimoMetai (String gimimoMetai){
        this.gimimoMetai = gimimoMetai;
    }
    public String getGimimoMetai(){
        return gimimoMetai;
    }
    public void setGrupe (String grupe){
        this.grupe = grupe;
    }
    public String getGrupe(){
        return grupe;
    }
    public void setVidurkis (double vidurkis){
        this.vidurkis = vidurkis;
    }
    public double getVidurkis(){
        return vidurkis;
    }

    public String getRandomGrupe(){
        int r = (int) (Math.random()*4);
        String grupe = new String [] {"Java","PHP","C#","C++"}[r];
        return grupe;
    }




    @Override
    public String toString() {
        return String.format("| Nr: %-5s\t|\t%-20s\t|\t%s\t|\tGrupe: %s\t|\tVidurkis: %.1f\t|",pazymejimoNumeris,pavardeVardas,gimimoMetai,grupe,vidurkis);
    }

    @Override
    public int compareTo(StudentasImpl sarasas) {
        return Comparator
                .comparing(StudentasImpl::getVidurkis).reversed()
                .compare(this,sarasas);
    }
}
