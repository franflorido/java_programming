package org.uma.mbd.mdAlturasV3.alturas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Mundo {

    private List<Pais> paises;

    public Mundo() {
        paises = new ArrayList<>();
    }

    public List<Pais> getPaises() {
        return paises;
    }

    public void leePaises(String file) throws FileNotFoundException {
        try (Scanner sc = new Scanner(new File(file))) {
           leePaises(sc);
        }
    }

    private void leePaises(Scanner sc) {
        while (sc.hasNextLine()) {
            String datosPais = sc.nextLine();
            try (Scanner scPais = new Scanner(datosPais)) {
                scPais.useDelimiter("[,]");
                scPais.useLocale(Locale.ENGLISH);
                String nombre = scPais.next();
                String continente = scPais.next();
                double altura = scPais.nextDouble();
                Pais pais = new Pais(nombre, continente, altura);
                paises.add(pais);
            }
        }
    }

    public List<String> getNombrePaises() {
        return paises.stream().map(Pais::getNombre)
                .collect(Collectors.toList());
    }

    public List<Pais> getPaisesDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equals(continente))
                .collect(Collectors.toList());
    }

    public List<Pais> paisesDe(List<String> continentes) {
        return List.of("Europa", "Asia", "South America").stream()
                .flatMap(cont -> paises.stream().
                                    filter(p-> p.getContinente().equals(cont)))
                .collect(Collectors.toList());
    }

    public List<Pais> getYMuestraPaisesDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equals(continente))
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public Set<String> getContinentes() {
        return paises.stream()
                .map(Pais::getContinente)
                .distinct()
                .collect(Collectors.toSet());
    }

    public List<String> getListContinentes() {
        return paises.stream()
                .map(Pais::getContinente)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Pais> extraeMenoresDeContinente(String continente, double maxAltura) {
            return paises.stream()
                    .filter(pais->pais.getContinente().equals(continente))// me quedo con los paises del comtinente
                    .sorted(Comparator.comparingDouble(Pais::getAltura))//ordenolas alturas
                    .takeWhile(pais->pais.getAltura() < maxAltura).//me quedo con los menores que maxAltura
                    collect(Collectors.toList());//obtengo la lista
    }

    public List<Pais> extraeMayoresDeContinente(String continente, double maxAltura) {
        return paises.stream()
                .filter(pais->pais.getContinente().equals(continente))
                .sorted(Comparator.comparing(Pais::getAltura))
                .dropWhile(pais->pais.getAltura() < maxAltura).
                        collect(Collectors.toList());
    }

    public void muestraNombrePaises() {
        paises.stream()
                .map(Pais::getNombre)
                .forEach(System.out::println);
    }

    public boolean todosMayores(double altura) {
        return paises.stream()
                .allMatch(p -> p.getAltura() > altura);
    }

    public Optional<Pais> masBajoDeContinente(String continente) {
        return paises.stream()
                .filter(pais->pais.getContinente().equals(continente))
                .sorted(Comparator.comparingDouble(Pais::getAltura))
                .findFirst();
    }

    public Pais paisMayorAltura() {
        return paises.stream()
                .max(Comparator.comparingDouble(Pais::getAltura))
                .get();
    }

    public long numPaisesQueVerifican(Predicate<Pais> pred) {
        return paises.stream()
                .filter(pred)
                .count();
    }

    public Pais[] arrayDePaises(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equals(continente))
                .toArray(Pais[]::new);
    }

    public double sumaAlturas() {
        return paises.stream()
                .map(Pais::getAltura)
                .reduce(Double::sum)
                .get();
    }

    public double suma2Alturas() {
        return paises.stream()
                .map(Pais::getAltura)
                .reduce(0d, Double::sum);
    }

    public double suma3Alturas() {
        return paises.stream()
                .map(Pais::getAltura)
                .reduce(0d, Double::sum,Double::sum);
    }

    public Set<Pais> paisesOrdDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equalsIgnoreCase(continente))
                .collect(TreeSet<Pais>::new
                        , Set::add
                        , Set::addAll);
    }

    public Set<String> paisesConColector() {
        return paises.stream()
                .map(Pais::getNombre)
                .collect(new MiColector());
    }

    public Set<Double> alturasDelContinente(String continente) {
        return paises.stream()
                .filter(p -> p.getContinente().equals(continente))
                .collect(Collectors.mapping(Pais::getAltura
                        ,Collectors.toSet()));
    }

    public long numPaisesMenoresQue(double maxAlt) {
        return paises.stream()
                .filter(p -> p.getAltura() < maxAlt)
                .collect(Collectors.counting());
    }

    public int numIntPaisesMenoresQue(double d) {
        return paises.stream()
                .filter(p -> p.getAltura() < d)
                .collect(Collectors.summingInt(pais -> 1));
    }

    public Map<Boolean, List<Pais>> separaPor(Predicate<Pais> pred) {
        return paises.stream()
                .collect(Collectors.partitioningBy(pred));
    }

    public Map<String, List<Pais>> paisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(Pais::getContinente));
    }

    public Map<String, Long> numPaisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(Pais::getContinente
                        ,Collectors.counting()));
    }

    public Map<String, Set<Double>> alturasPorContinente() {
        return paises.stream()
                .collect(Collectors
                        .groupingBy(Pais::getContinente
                                ,Collectors.mapping(Pais::getAltura
                                        ,Collectors.toSet())));
    }

    public Map<String, Integer> numIntPaisesPorContinente() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::getContinente
                        ,Collectors.summingInt(p -> 1)));
    }

    public Map<Double, Set<String>> continentesPorAltura() {
        return paises
                .stream()
                .collect(Collectors.groupingBy(
                        Pais::getAltura
                        ,Collectors.mapping(Pais::getContinente,
                                Collectors.toCollection(TreeSet::new))));
    }

    public Map<Double, Set<String>> continentesPorAlturaOrd() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::getAltura,
                        TreeMap::new,
                        Collectors.mapping(Pais::getContinente
                                ,Collectors.toCollection(TreeSet::new))));
    }

    public String stringDeContinentes() {
        return paises.stream()
                .map(Pais::getContinente)
                .distinct()
                .collect(Collectors.joining("<", ",", ">"));
    }

    public Map<String,Long>  nppl () {
        return paises.stream()
                .map(Pais::getContinente)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()));
    }

    public Map<String,Map<Double,Long>> nppccua() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        Pais::getContinente,
                        Collectors.groupingBy(
                                pais->((int)(pais.getAltura()*10))/10.0,
                                Collectors.counting())));
    }

    public Map<Double, Map<String, List<Pais>>> lppayc() {
        return paises.stream()
                .collect(Collectors.groupingBy(
                        pais -> ((int)(pais.getAltura()*10))/10.0,
                        Collectors.groupingBy(
                                Pais::getContinente)));
    }

    public Map<Long, Set<Integer>> nlpp() {
        Map<Integer, Long> map =
                paises.stream()
                        .collect(Collectors.groupingBy(pais -> pais.getNombre().length(),
                                Collectors.counting()));
        return map.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        TreeMap::new,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toSet())));
    }




}
