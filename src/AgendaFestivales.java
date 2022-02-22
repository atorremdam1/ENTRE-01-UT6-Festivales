
import java.util.*;


/**
 * Esta clase guarda una agenda con los festivales programados
 * en una serie de meses
 *
 * La agenda guardalos festivales en una colecci�n map
 * La clave del map es el mes (un enumerado festivales.modelo.Mes)
 * Cada mes tiene asociados en una colecci�n ArrayList
 * los festivales  de ese mes
 *
 * Solo aparecen los meses que incluyen alg�n festival
 *
 * Las claves se recuperan en orden alfab�ico
 *
 */
public class AgendaFestivales {

    private TreeMap<Mes,ArrayList<Festival>> agenda;
    
    public AgendaFestivales() {
        this.agenda = new TreeMap<>();
    }

    /**
     * a�ade un nuevo festival a la agenda
     *
     * Si la clave (el mes en el que se celebra el festival)
     * no existe en la agenda se crear� una nueva entrada
     * con dicha clave y la colecci�n formada por ese �nico festival
     *
     * Si la clave (el mes) ya existe se a�ade el nuevo festival
     * a la lista de festivales que ya existe ese ms
     * insert�ndolo de forma que quede ordenado por nombre de festival.
     * Para este segundo caso usa el m�todo de ayuda
     * obtenerPosicionDeInsercion()
     *
     */
    public void addFestival(Festival festival) {

        if (agenda.containsKey(festival.getMes())) {
            ArrayList<Festival> festivales = agenda.get(festival.getMes());
            int indice = obtenerPosicionDeInsercion(festivales,festival);
            festivales.add(indice,festival);
            agenda.put(festival.getMes(),festivales);
        }
        else {
            ArrayList<Festival> festivales = new ArrayList<>();
            int indice = obtenerPosicionDeInsercion(festivales,festival);
            festivales.add(indice,festival);
            agenda.put(festival.getMes(),festivales);
        }

    }

    /**
     *
     * @param festivales una lista de festivales
     * @param festival
     * @return la posici�n en la que deber�a ir el nuevo festival
     * de forma que la lista quedase ordenada por nombre
     */
    private int obtenerPosicionDeInsercion(ArrayList<Festival> festivales,
                                           Festival festival) {
       int pos = 0;
        for (Festival fest : festivales) {
            if (festival.getNombre().compareTo(fest.getNombre()) > 0) {
                return pos;
            }
            else {
                pos++;
            }
        }
       return pos;
    }

    /**
     * Representaci�n textual del festival
     * De forma eficiente
     *  Usa el conjunto de entradas par recorrer el map
     */
    @Override
    public String toString() {
        //TODO
        
        return null;
    }

    /**
     *
     * @param mes el mes a considerar
     * @return la cantidad de festivales que hay en ese mes
     * Si el mes no existe se devuelve -1
     */
    public int festivalesEnMes(Mes mes) {
        if (!agenda.containsKey(mes)) {
            return -1;
        }
        return agenda.get(mes).size();
    }

    /**
     * Se trata de agrupar todos los festivales de la agenda
     * por estilo.
     * Cada estilo que aparece en la agenda tiene asociada una colecci�n
     * que es el conjunto de nombres de festivales que pertenecen a ese estilo
     * Importa el orden de los nombres en el conjunto
     *
     * Identifica el tipo exacto del valor de retorno
     */
    public LinkedHashMap<Estilo,TreeSet<String>> festivalesPorEstilo() {
        LinkedHashMap<Estilo,TreeSet<String>> grupos = new LinkedHashMap<>();
        Set<Estilo> claves = grupos.keySet();
        Iterator<Estilo> it1 = claves.iterator();
        while (it1.hasNext()) {
            Mes[] mes = Mes.values();
            for (int i = 0; i < mes.length; i++) {
                
            }
        }
        return null;
    }

    /**
     * Se cancelan todos los festivales organizados en alguno de los
     * lugares que indica el conjunto en el mes indicado. Los festivales
     * concluidos o que no empezados no se tienen en cuenta
     * Hay que borrarlos de la agenda
     * Si el mes no existe se devuelve -1
     *
     * Si al borrar de un mes los festivales el mes queda con 0 festivales
     * se borra la entrada completa del map
     */
    public int festivalesPorEstilo(HashSet<String> lugares, Mes mes) {
       //TODO
        
        return 0;
    }
}
