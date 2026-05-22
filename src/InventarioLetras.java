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

        if (letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("El carácter no es una letra válida.");
        }

        return inventario[letra - 'a'];
    }

    // fija el conteo de una letra a un valor específico
    public void set(char letra, int valor) {
        letra = Character.toLowerCase(letra);

        if (letra < 'a' || letra > 'z') {
            throw new IllegalArgumentException("El carácter no es una letra válida.");
        }

        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }

        int posicion = letra - 'a';
        int conteoAnterior = inventario[posicion];

        // actualizamos los contadores según el cambio
        totalCount = totalCount - conteoAnterior + valor;

        if (conteoAnterior > 0 && valor == 0) {
            nonZeroCount--;
        } else if (conteoAnterior == 0 && valor > 0) {
            nonZeroCount++;
        }

        inventario[posicion] = valor;
    }

    // devuelve el inventario como [aaaabbb...]
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < inventario[i]; j++) {
                sb.append((char) ('a' + i));
            }
        }

        sb.append("]");
        return sb.toString();
    }
}