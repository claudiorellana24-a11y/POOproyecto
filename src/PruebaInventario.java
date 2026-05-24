public class PruebaInventario {

    public static void main(String[] args) {

        System.out.println("=== prueba básica ===");
        InventarioLetras inv = new InventarioLetras("Hola Mundo");
        System.out.println("size: " + inv.size());        // 9
        System.out.println("isEmpty: " + inv.isEmpty());  // false
        System.out.println("get('o'): " + inv.get('o'));  // 2
        System.out.println("toString: " + inv);           // [adhlmnoou]

        System.out.println("\n=== prueba cifrado César ===");
        System.out.println("encriptarCesar('a'): " + inv.encriptarCesar('a'));          // d
        System.out.println("encriptarPalabra(play): " + inv.encriptarPalabra("play", 3)); // sodb
        System.out.println("desencriptarPalabra(sodb): " + inv.desencriptarPalabra("sodb", 3)); // play

        System.out.println("\n=== prueba add ===");
        InventarioLetras inv1 = new InventarioLetras("Alan Turing");
        InventarioLetras inv2 = new InventarioLetras("Ada Lovelace");
        InventarioLetras suma = inv1.add(inv2);
        System.out.println("suma: " + suma);

        System.out.println("\n=== prueba amplifies ===");
        InventarioLetras inv3 = new InventarioLetras("ab");
        System.out.println("original: " + inv3);
        System.out.println("amplificado x3: " + inv3.amplifies(3));

        System.out.println("\n=== prueba subtract ===");
        InventarioLetras inv4 = new InventarioLetras("aabbcc");
        InventarioLetras inv5 = new InventarioLetras("ab");
        System.out.println("resta válida: " + inv4.subtract(inv5));
        System.out.println("resta inválida: " + inv5.subtract(inv4));

        System.out.println("\n=== prueba excepciones ===");
        try {
            inv.get('5');
        } catch (IllegalArgumentException e) {
            System.out.println("excepción get: " + e.getMessage());
        }

        try {
            inv.set('a', -1);
        } catch (IllegalArgumentException e) {
            System.out.println("excepción set: " + e.getMessage());
        }
    }
}