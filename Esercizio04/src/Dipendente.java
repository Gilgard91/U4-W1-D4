public class Dipendente {
    private static double stipendioBase = 1000;
    private int matricola;
    private double stipendio;
    private double importoOrarioStraordinario;
    private Livello livello;
    private Dipartimento dipartimento;

    enum Livello{
        OPERAIO, IMPIEGATO, QUADRO, DIRIGENTE
    }

    public enum Dipartimento{
        PRODUZIONE, AMMINISTRAZIONE, VENDITE
    }

    public Dipendente(int matricola, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.dipartimento = dipartimento;
        this.stipendio = stipendioBase;
        this.importoOrarioStraordinario = 30;
        this.livello = Dipendente.Livello.OPERAIO;
    }

    public Dipendente(int matricola, double stipendio, double importoOrarioStraordinario,
                      Livello livello, Dipartimento dipartimento) {
        this.matricola = matricola;
        this.stipendio = stipendio;
        this.importoOrarioStraordinario = importoOrarioStraordinario;
        this.livello = livello;
        this.dipartimento = dipartimento;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "matricola=" + matricola +
                ", stipendio=" + stipendio +
                ", importoOrarioStraordinario=" + importoOrarioStraordinario +
                ", livello=" + livello +
                ", dipartimento=" + dipartimento +
                '}';
    }




    public int getMatricola() {
        return matricola;
    }

    public double getStipendio() {
        return stipendio;
    }

    public Livello getLivello() {
        return livello;
    }

    public Dipartimento getDipartimento() {
        return dipartimento;
    }

    public double getImportoOrarioStraordinario() {
        return importoOrarioStraordinario;
    }

    public void setImportoOrarioStraordinario(double importo) {
        this.importoOrarioStraordinario = importo;
    }

    public Livello promuovi() {
        switch (livello) {
            case OPERAIO:
                livello = Livello.IMPIEGATO;
                stipendio *= 1.2;
                break;
            case IMPIEGATO:
                livello = Livello.QUADRO;
                stipendio *= 1.5;
                break;
            case QUADRO:
                livello = Livello.DIRIGENTE;
                stipendio *= 2;
                break;
            case DIRIGENTE:
                System.out.println("///");
                break;
        }
        return livello;
    }

    public static double calcolaPaga(Dipendente dipendente) {
        return dipendente.stipendio;
    }

    public static double calcolaPaga(Dipendente dipendente, int oreStraordinario) {
        return dipendente.stipendio + (oreStraordinario * dipendente.importoOrarioStraordinario);
    }
}
