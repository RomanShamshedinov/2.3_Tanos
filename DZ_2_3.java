public class DZ_2_3 {
    public static void main(String[] args) {
        long[] array = {58, 36, 1, 98, 45, 15, 67, 89, 49, 50};
        System.out.println("Массив до сортировки");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        array = sort(array);
        System.out.println("Массив после сортировки");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static long[] sort(long[] mass) {

        float avg = 0;
        long sum = 0;
        long[] podmass = new long[mass.length]; //Подмассив
        long[] massl; //Левый массив
        long[] massr; //Правый массив
        int countl = 0; //Длинна левого массива
        int countr = 0; //Длинна правого массива

        //Найдем среднее массива
        for (int i = 0; i < mass.length; i++) {
            sum += mass[i];
        }
        avg = (float) sum / mass.length;

        //Первая итеррация
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] >= avg) {
                podmass[podmass.length - 1 - countr] = mass[i];
                countr++;
            } else {
                podmass[countl] = mass[i];
                countl++;
            }
        }

        //Копируем подмассив после итерраций в массив
        for (int i = 0; i < mass.length; i++) {
            mass[i] = podmass[i];
        }

        massl = new long[countl]; //Копируем левую часть массива
        for (int i = 0; i < countl; i++) {
            massl[i] = mass[i];
        }

        massr = new long[countr]; //Копируем правую часть массива
        for (int i = 0; i < countr; i++) {
            massr[i] = mass[mass.length - countr + i];
        }

        if (countl > 1) {
            massl = sort(massl);
        }
        for (int i = 0; i < massl.length; i++) {
            mass[i] = massl[i];
        }


        if (countr > 1) {
            massr = sort(massr);
        }

        int k = 0;
        for (int i = countl; i < mass.length; i++) {
            mass[i] = massr[k];
            k++;
        }
        return mass;
    }
}
