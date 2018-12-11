package ru.job4j.condition;

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a=a;
        this.b=b;
        this.c=c;
    }

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (ab + ac + bc) / 2
     *
     * @param ab расстояние между точками a b
     * @param ac расстояние между точками a c
     * @param bc расстояние между точками b c
     * @return Перимент.
     */

    public  double period(double ab, double ac, double bc){
        return  (ab + ac + bc)/2;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * @return Вернуть прощадь, если треугольник существует или -1, если треугольника нет.
     */
    public double area() {
        double rsl = -1; // мы устанавливаем значение -1, так как может быть что треугольника нет. Это значение говорит о том. что треугольника нет.
        double ab = a.distanceTo(b);
        double ac = a.distanceTo(c);
        double bc = b.distanceTo(c);
        double p = period(ab, ac, bc);
        if (this.exist(ab, ac, bc)) {
            // написать формулу для расчета площади треугольника.
            rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc)); //вместо многоточия нужно написать формулу Герона с подставленными переменные ab, ac, dc, p.
        }
        return rsl;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return Это треугольник.
     */
    private boolean exist(double ab, double ac, double bc) {
        boolean rsl = true;
        if ((ab <=0.0d) || (ac <= 0.0d) || (bc <= 0.0d)){
            rsl = false;
        }
        return rsl;
    }
}
