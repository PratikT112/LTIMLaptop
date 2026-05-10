package org.example.AirLineSimulator;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AirLineSimulationApplication {

    public static void main(String[] args) {

        List<String> baseList = List.of("KORD", "KJFK", "VIDP", "OMDB", "EGLL", "SPIM","NZCH", "WSSS", "KLAX", "RJTT", "EDDF", "YSSY", "SBGR", "SAEZ");

        List<String> routeList = null;
        try {
            routeList = RouteDataReader.routeDataReadBufferedReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<PaxRoute> b787PaxRoutes = new ArrayList<>();
        for(String route: routeList){
            PaxRoute newPaxRoute = new PaxRoute(route, baseList);
            b787PaxRoutes.add(newPaxRoute);
        }

        for(PaxRoute paxRoute : b787PaxRoutes){
//            System.out.println(paxRoute);
        }
        List<PaxRoute> listSorted = b787PaxRoutes.stream().sorted(Comparator.comparing(x -> x.planeId.getMainId())).toList();
        listSorted.forEach(System.out::println);


        PlaneId id = new PlaneId("N-0166-2");
//        System.out.println(id);

        Map<String, Long> collect = b787PaxRoutes
                .stream()
                .collect(Collectors.groupingBy(x -> x.stopOver, Collectors.counting()));

        LinkedHashMap<String, Long> collect2 = b787PaxRoutes.stream().collect(Collectors.groupingBy(x -> x.stopOver, Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));


        LinkedHashMap<String, Long> collect1 = collect
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        /*
        System.out.println(collect);
        System.out.println(collect1);
        System.out.println(collect2);*/

//        list.forEach(System.out::println);

//        Map<String, Long> routesByPlaneCount = b787PaxRoutes.stream().collect(Collectors.groupingBy(x -> x.planeModel, Collectors.counting()));
//        System.out.println("Routes By Planes Below");
//        System.out.println(routesByPlaneCount);
//
//        Map<String, Long> baseWiseRouteCount = b787PaxRoutes.stream().collect(Collectors.groupingBy(x -> x.base, Collectors.counting()));
//        Map<String, List<PaxRoute>> baseWiseRoutes = b787PaxRoutes.stream().collect(Collectors.groupingBy(x -> x.base));
//        LinkedHashMap<String, Long> baseWiseRouteCountDesc = baseWiseRouteCount
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
//        System.out.println(baseWiseRouteCount);
//
//        LinkedHashMap<String, Long> collect = baseWiseRouteCount
//                .entrySet()
//                .stream()
//                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
//
//
//        List<String> klax = b787PaxRoutes.stream().filter(x -> x.base.equals("KLAX")).filter(x -> x.planeModel.equals("B787-8")).map(x -> String.join("-", x.source, x.destination)).toList();
//
//
//
//
//        Map<String, Map<String, Long>> baseWisePlaneWiseRouteCount = baseWisePlaneWiseRouteCount(b787PaxRoutes);
//        System.out.println("START");
//        baseWisePlaneWiseRouteCount.entrySet().forEach(System.out::println);
//        System.out.println("END");
//
//        Map<String, Long> basewise787RouteCount = b787PaxRoutes.stream().filter(x -> x.planeModel.equals("B787-8")).collect(Collectors.groupingBy(x -> x.base, Collectors.counting()));
//        System.out.println("basewise787RouteCount");
//        System.out.println(basewise787RouteCount);
//
////        List<Route> omdb = b787Routes.stream().filter(x -> x.isPointInvolved("EGLL")).filter(x -> x.getPlaneModel().equals("B787-8")).toList();
////        omdb.stream().forEach(System.out::println);
//
//        List<PaxRoute> klax1 = b787PaxRoutes.stream().filter(x->x.planeModel.equals("B787-8")).filter(x->x.base.equals("RJTT")).toList();
//        System.out.println("START");
//        klax1.forEach(System.out::println);
//        System.out.println("END");
//
////        System.out.println(baseWiseRouteCountDesc);
////
////        Map<String, Long> b787RoutesByBaseCount = b787Routes.stream().filter(x -> x.planeModel.equals("B787-8")).collect(Collectors.groupingBy(x -> x.base, Collectors.counting()));
////        LinkedHashMap<String, Long> b787RoutesByCountDesc = b787RoutesByBaseCount.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));
////        System.out.println(b787RoutesByCountDesc );
//
//        List<PaxRoute> baseToBasePaxRoutes = baseToBaseRoutes(b787PaxRoutes, baseList);
//        baseToBasePaxRoutes.forEach(System.out::println);
    }

    public static Map<String, Map<String, Long>> baseWisePlaneWiseRouteCount(List<PaxRoute> paxRouteList){
        return paxRouteList.stream().collect(Collectors.groupingBy(PaxRoute::getBase, Collectors.groupingBy(PaxRoute::getPlaneModel, Collectors.counting())));
    }

    public static List<PaxRoute> baseToBaseRoutes(List<PaxRoute> paxRouteList, List<String> baseList){
        return paxRouteList.stream().filter(x->x.isBaseToBase(baseList)).toList();
    }

}
