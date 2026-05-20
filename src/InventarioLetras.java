public class InventarioLetras {

    // las 26 letras del abecedario
    private int[] inventario;

    // cuántas letras hay en total
    private int totalCount;

    // cuántas letras distintas hay
    private int nonZeroCount;

    public InventarioLetras(String data) {
        inventario = new int[26];
        totalCount = 0;
        nonZeroCount = 0;

        // paso todo a minúscula para no distinguir entre A y a
        String texto = data.toLowerCase();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            // solo cuento letras, ignoro espacios y números
            if (c >= 'a' && c <= 'z') {
                int posicion = c - 'a'; // a=0, b=1, etc

                if (inventario[posicion] == 0) {
                    nonZeroCount++;
                }

                inventario[posicion]++;
                totalCount++;
            }
        }
    }

    // retorna el total de letras
    public int size() {
        return totalCount;
    }

    // retorna true si no hay ninguna letra
    public boolean isEmpty() {
        return nonZeroCount == 0;
    }

    // retorna cuántas veces aparece una letra
    public int get(char letra) {
        letra = Character.toLowerCase(letra);

        // si no es letra lanza error
        if (letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("El carácter no es una letra válida.");
        }

        return inventario[letra - 'a'];
    }
}