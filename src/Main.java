import com.sun.xml.internal.bind.marshaller.NoEscapeHandler;

import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
/*
Rol de Jacinto: Entendido de Arte. (El día de mañana mi programa me podrá permitir, ver estatuas, música, teatro, etc…
        Clase Elemento de Arte -> Cuadro.
        Año de realización.
        Autor.
        Clase Cuadro
        Tipo de Pintura: (Oleo, acuarela,  fresco)
        Clase SitioWeb
        ArrayList <ElementoDeArte>
			Add (Elemento de Arte)
                    Search (Elemento de Arte)
                    Integer numeroDeElementosEnLaWeb.
                    Integer MediaRealizacion.
*/
abstract class ElementoDeArte
{
    private Integer añoDeRealizacion;
    private String autor;

    public ElementoDeArte(Integer añoDeRealizacion, String autor) {
        setAñoDeRealizacion(añoDeRealizacion);
        setAutor(autor);
    }

    public Integer getAñoDeRealizacion() {
        return añoDeRealizacion;
    }

    public void setAñoDeRealizacion(Integer añoDeRealizacion) {
        if (añoDeRealizacion > 2023)
            this.añoDeRealizacion = 2023;
        else
            this.añoDeRealizacion = añoDeRealizacion;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == "") {
            this.autor = "Anonimo";}
        else {
            this.autor = autor;}
    }

    @Override
    public String toString() {
        return "ElementoDeArte{" +
                "añoDeRealizacion=" + añoDeRealizacion +
                ", autor='" + autor + '\'' +
                '}';
    }
}
class Musica extends ElementoDeArte
{
    String estiloMusical;

    public Musica(Integer añoDeRealizacion, String autor, String estiloMusical) {
        super(añoDeRealizacion, autor);
        this.estiloMusical = estiloMusical;
    }


    @Override
    public String toString() {
        return super.toString()+
                "Musica{" +
                "estiloMusical='" + estiloMusical + '\'' +
                '}';
    }
}
class Cuadro extends ElementoDeArte
{
    String TipoDePintura;
    String TipoDeMadera;


    public Cuadro(Integer añoDeRealizacion, String autor, String tipoDePintura, String tipoDeMadera) {
        super(añoDeRealizacion, autor);
        TipoDePintura = tipoDePintura;
        TipoDeMadera = tipoDeMadera;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Cuadro{" +
                "TipoDePintura='" + TipoDePintura + '\'' +
                ", TipoDeMadera='" + TipoDeMadera + '\'' +
                '}';
    }
}
class SitioWeb
{
    private ArrayList<ElementoDeArte> Coleccion = new ArrayList<ElementoDeArte>(1000);
    public Integer size()
    {
        return Coleccion.size();
    }
    public void add(ElementoDeArte elementoDeArte) {
        Coleccion.add(elementoDeArte);
    }

    @Override
    public String toString() {
        String Cadena;
        Cadena = "SitioWeb{" + "Coleccion=";
        for(ElementoDeArte Item : Coleccion) {
            Cadena += Item.toString() + "\n";
        }

        return Cadena;
    }
}
class Estatua extends ElementoDeArte
{
    String TipoDePiedra;


    public Estatua(Integer añoDeRealizacion, String autor, String tipoDePiedra) {
        super(añoDeRealizacion, autor);
        TipoDePiedra = tipoDePiedra;
    }


    @Override
    public String toString() {
        return super.toString()+
                "Estatua{" +
                "TipoDePiedra='" + TipoDePiedra + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        // Press Alt+Intro with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        SitioWeb miSitioWeb = new SitioWeb();
        ElementoDeArte LosGirasoles = new Cuadro(1865,"Van Gong","abstracta","ebano");
        ElementoDeArte LasLanzas = new Cuadro(1765,"Velazquez","paisaje","pino");
        ElementoDeArte ElGrito = new Cuadro(1956,"Macarena","impresionista","roble");
        ElementoDeArte SixSixSix = new Musica(1996,"Iron Maiden","Metal");
        ElementoDeArte NovenaSinfornia = new Musica(1765,"Betoveen","Clasica");
        ElementoDeArte Samotracia = new Estatua(300,"","Marmol");
        
        miSitioWeb.add(LosGirasoles);
        miSitioWeb.add(LasLanzas);
        miSitioWeb.add(ElGrito);
        miSitioWeb.add(SixSixSix);
        miSitioWeb.add(NovenaSinfornia);
        miSitioWeb.add(Samotracia);

        System.out.println(miSitioWeb);
    }
}