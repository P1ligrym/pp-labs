package com.company;
import java.util.ArrayList;
import java.util.List;

class Fibonacci {
    /**Поле Фібоначчі*/
    private List<Integer> fibonacci = new ArrayList();

/**Конструктор з двома параметрами,два перші числа ряду Фібоначчі
 * @param n1 перше число ряду
 * @param n2 другк число ряду
 * @see Fibonacci#Fibonacci(int, int) */
    Fibonacci(int n1, int n2) {
        this.fibonacci.add(n1);
        this.fibonacci.add(n2);
    }

/**Метод в якому ми генеруєм  ряд Фібоначчі і записуєму туди два перші числа
 * @param length довжина*/
    public void generate(int length) {
        for(int i = 0; i < length - 2; i++) {
            this.fibonacci.add(
                    this.fibonacci.get(this.fibonacci.size() - 1) +
                            this.fibonacci.get(this.fibonacci.size() - 2));
        }
    }

/**Метод в якому ми виводим результат з числами Фібоначчі заданами нами числами
 * @return повертає ряд Фібоначчі */
    public ArrayList<Integer> getFibonacci() {
        ArrayList<Integer> result = new ArrayList(this.fibonacci);
        System.out.println(result.toString());
        return result;
    }

}
