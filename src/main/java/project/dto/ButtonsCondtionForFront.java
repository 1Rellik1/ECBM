package project.dto;

/**
 * Дто состояния постов
 */
public class ButtonsCondtionForFront {
    //состояние поста
    private int btype;
    //номер поста
    private int number;

    /**
     * Возвращает состояние поста
     * @return
     * состояние поста
     */
    public int getBtype() {
        return btype;
    }

    /**
     * Устанавливает состояние поста
     * @param btype
     * состояние поста
     */
    public void setBtype(int btype) {
        this.btype = btype;
    }

    /**
     * Возвращает номер поста
     * @return
     * номер поста
     */
    public int getNumber() {
        return number;
    }

    /**
     * Устанавливает номер поста
     * @param number
     * номер поста
     */
    public void setNumber(int number) {
        this.number = number;
    }
}
