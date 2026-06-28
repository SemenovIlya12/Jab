package ru.Semenov.Persons;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Телефонный справочник (номер – имя).
 */
public class PhoneVocab {
    private final Map<String, String> vocab = new HashMap<>();

    /**
     *  Создает пустой справочник
     */
    public PhoneVocab() {
        // empty
    }

    /**
     * Добавляет или обновляет запись.
     *
     * @param phone номер телефона
     * @param name  имя абонента
     */
    public void add(String phone, String name) {
        if (!isNameExists(name)) {
            vocab.put(phone,name);
        } else {
            final String oldPhone = getNumberByName(name);
            System.out.println("Old phone: " + oldPhone);
            if (!oldPhone.equals("-1")) {
                vocab.remove(oldPhone);
                vocab.put(phone, name);
            }
        }
    }

    /**
     * Удаляет запись по имени.
     *
     * @param name имя абонента
     */
    public void remove(String name) {
        final String number = getNumberByName(name);
        if (number.equals("-1")) {
            vocab.remove(number);
        }
    }

    /**
     * Возвращает количество записей.
     *
     * @return размер справочника
     */
    public int getSize() {
        return vocab.size();
    }

    /**
     * Проверяет наличие номера или имени.
     *
     * @param something номер или имя
     * @return true, если найдено
     */
    public boolean isInVocab(String something) {
        final Set<String > keys = vocab.keySet();
        final Collection<String> vals = vocab.values();

        return keys.contains(something)
                || vals.contains(something);
    }

    /**
     * Возвращает номер по имени.
     *
     * @param name имя
     * @return номер или сообщение об отсутствии
     */
    public String getNumber(String name) {
        final String number = getNumberByName(name);
        return number.equals("-1") ?
                number : "No information about " + name;
    }

    /**
     * Вспомогательная функция, проверяющая нахождение
     * имени в справочнике
     * @param name
     * @return номер / -1
     */
    private String getNumberByName(String name) {
        for (final Map.Entry<String, String> entry
                : vocab.entrySet()) {
            if (vocab.getValue().equals(name)) {
                return entry.getKey();
            }
        }

        return "-1";
    }

    /**
     * Возвращает список всех пар "номер имя".
     *
     * @return список строк
     */
    public ArrayList<String> getAllPairs() {
        final List<String> result = new ArrayList<>();
        for (final Map.Entry<String, String> entry
                : vocab.entrySet()) {
            result.add(entry.getKey() + " " + entry.getValue());
        }
        return result;
    }

    /**
     * Находит имена, содержащие подстроку.
     *
     * @param sub подстрока
     * @return список подходящих имён
     */
    public ArrayList<String> getNamesBySubstring(String sub) {
        final List<String> result = new ArrayList<>();
        for (final String name : vocab.values()) {
            if (name.contains(sub)) {
                result.add(name);
            }
        }
        return result;
    }

    /**
     * Возвращает все номера.
     *
     * @return список номеров
     */
    public ArrayList<String> getAllNumbers() {
        return new ArrayList<>(vocab.keySet());
    }

    /**
     * Возвращает все имена.
     *
     * @return список имён
     */
    public ArrayList<String> GetAllNames() {
        return new ArrayList<>(vocab.values());
    }

    /**
     * Проверяет есть ли имя в справочнике
     * @param Name
     * @return True (если имя есть) / False
     */
    private boolean isNameExists(String Name) {
        return vocab.containsValue(name);
    }

    /**
     * Возвращает строку со всеми записями.
     * @return текстовое представление
     */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, String> entry
                : vocab.entrySet()) {
            sb.append(entry.getKey())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }
        return sb.toString();
    }

}
