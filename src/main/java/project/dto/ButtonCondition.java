package project.dto;

/**
 *  Дто сущность состояния кнопки
 */
public class ButtonCondition {
    //состояние блока кнопок
    private int btype;
    //номер блока кнопок
    private int number;
    //кол-во нажатий на 1 кнопку
    private int Counter1;
    //кол-во нажатий на 2 кнопку
    private int Counter2;
    //кол-во нажатий на 3 кнопку
    private int Counter3;

    /**
     * Возвращает состояние блока кнопок
     * @return
     * состояние блока кнопок
     */
    public int getBtype() {
        return btype;
    }

    /**
     * Устанавливает состояние блока кнопок
     * @param btype
     * состояние блока кнопок
     */
    public void setBtype(int btype) {
        this.btype = btype;
    }

    /**
     * Возвращает номер блока кнопок
     * @return
     * номер блока кнопок
     */
    public int getNumber() {
        return number;
    }

    /**
     * Устанавливает номер блока кнопок
     * @param number
     * номер блока кнопок
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Возвращает кол-во нажатий на 1 кнопку
     * @return
     * кол-во нажатий на 1 кнопку
     */
    public int getCounter1() {
        return Counter1;
    }

    /**
     * Устанавливает кол-во нажатий на 1 кнопку
     * @param counter1
     * кол-во нажатий на 1 кнопку
     */
    public void setCounter1(int counter1) {
        Counter1 = counter1;
    }

    /**
     * Возвращает кол-во нажатий на 2 кнопку
     * @return
     * кол-во нажатий на 2 кнопку
     */
    public int getCounter2() {
        return Counter2;
    }

    /**
     * Устанавливает кол-во нажатий на 2 кнопку
     * @param counter2
     * кол-во нажатий на 2 кнопку
     */
    public void setCounter2(int counter2) {
        Counter2 = counter2;
    }

    /**
     * Возвращает кол-во нажатий на 3 кнопку
     * @return
     * кол-во нажатий на 3 кнопку
     */
    public int getCounter3() {
        return Counter3;
    }

    /**
     * Устанавливает кол-во нажатий на 3 кнопку
     * @param counter3
     * кол-во нажатий на 3 кнопку
     */
    public void setCounter3(int counter3) {
        Counter3 = counter3;
    }
}
