package ru.job4j.calculate;

/**
 * Calculate task class.
 * @author Ilya B 
 * @version 1
 * @since 03.12.18
 */
public class Calculate {
	double result;
	/**
	 * Суммирование аргментов.
	 *@param first первое число
	 *@param second второе число
	 */
	void add(double first, double second) {
		this.result = first + second;
	}
	/**
	 * Вычитание первого аргумента из второго.
	 *@param first первое число
	 *@param second второе число
	 */
	void subtract(double first, double second) {
		this.result = first - second;
	}

	/**
	 * Деление аргументов.
	 *@param first первое число
	 *@param second второе число
	 */
	void div(double first, double second) {
		this.result = first / second;
	}

	/**
	 * Умножение аргументов.
	 *@param first первое число
	 *@param second второе число
	 */
	void multiply(double first, double second) {
		this.result = first * second;
	}
	/**
	 * Возвращение результата
	 *@return Возвращение результата вычисления
	 */
	public double getResult() {
		return this.result;
	}
}