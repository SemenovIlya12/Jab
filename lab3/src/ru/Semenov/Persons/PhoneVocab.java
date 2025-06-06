package ru.Semenov.Persons;

import java.util.*;


public class PhoneVocab {
    private Map<String, String> vocab;


    public PhoneVocab() {
        this.vocab = new HashMap<>();
        this.vocab.put("111-222", "Ivan");
        this.vocab.put("323-232", "Volodimir");
        this.vocab.put("014-1480", "Ben");
    }

    /**
     * Добавляет имя и телефон человека в справочник
     * @param Phone номер
     * @param Name имя
     */
    public void add(String Phone, String Name) {
        if (!isNameExists(Name)) {
            vocab.put(Phone,Name);
        } else {
            String numbr = GetNumberByName(Name);
            System.out.println("Old phone: " + numbr);
            if (!Objects.equals(numbr, "-1")) {
                vocab.remove(numbr);
                vocab.put(Phone, Name);
            }
        }
    }

    /**
     * удаляет чеовека из справочника
     * @param Name имя человека, которого необходимо удалить из справочника
     */
    public void remove(String Name) {
        String number = GetNumberByName(Name);
        if (number != "-1") {
            vocab.remove(number);
        }
    }

    /**
     * Возвращает размер (количество номеров) в справочнике
     * @return размер справочника
     */
    public int getSize() {
        return vocab.size();
    }

    /**
     * Проверяет, находится ли данный номер или имя в справочнике
     * @param Something имя или номер (нечто)
     * @return True если номер или имя входит в справочник, False иначе.
     */
    public boolean isInVocab(String Something) {
        Set<String > Kset = vocab.keySet();
        Collection<String> vals = vocab.values();

        return Kset.contains(Something) || vals.contains(Something);
    }

    /**
     * Находит номер в справочнике, если номер найден - выводит его, иначе - сообщение, что такого номера нет в справочнике.
     * @param Name имя, по которому будет вестись поиск
     * @return Номер, или "There is no information about" + имя в справочнике
     */
    public String GetNumber(String Name) {
        Set<String> set = vocab.keySet();
        String result = "-1";
        for (String key : set) {
            if (vocab.get(key) == Name ) {
                result = key;
            }
        }

        return result != "-1" ? result : "There`s no information about " + Name;
    }

    /**
     * Вспомогательный метод, использующийся исключительно в методах справочника.
     * @param Name имя
     * @return Номер или -1 как строка
     */
    private String GetNumberByName(String Name) {
        Set<String> set = vocab.keySet();

        for (String key : set) {
            if (vocab.get(key) == Name ) {
                return key;
            }
        }

        return "-1";
    }

    /**
     * Возвращает все пары ключ-значение, или же номер-имя из справочника
     * @return пары ключ-значение из справочника
     */
    public ArrayList<String> getAllPairs() {
        Set<String> set = vocab.keySet();

        ArrayList<String> result = new ArrayList<String>();

        for (String key : set) {
            result.add(key + " " +  vocab.get(key));
        }

        return result;
    }

    /**
     * Возвращает список имен, в которые входит подсртока (часть имени)
     * @param sub подстрока, по которой будет произведен поиск
     * @return список имен
     */
    public ArrayList<String> getNamesBySubstring(String sub) {
        Collection<String> vals = vocab.values();

        ArrayList<String> result = new ArrayList<String>();

        for (String val : vals) {
            if (val.contains(sub)) {
                result.add(val);
            }
        }

        return result;
    }

    /**
     * Возвращает список всех номеров в справочнике
     * @return список номеров
     */
    public ArrayList<String> getAllNumbers() {
        ArrayList<String> numbers = new ArrayList<String>();

        Collection<String> keys = vocab.keySet();

        for (String key : keys) {
            numbers.add(key);
        }

        return numbers;
    }

    /**
     * Возвращает список всех имен в справочнике
     * @return список имен
     */
    public ArrayList<String> getAllNames() {
        ArrayList<String> names = new ArrayList<String>();

        Collection<String> vals = vocab.values();

        for (String val : vals) {
            names.add(val);
        }

        return names;
    }

    /**
     * Проверяет, существует ли данное имя в справочнике
     * @param Name имя
     * @return boolean - существует ли имя в справочнике
     */
    private boolean isNameExists(String Name) {
        Set<String> set = vocab.keySet();

        for (String key : set) {
            if (vocab.get(key) == Name) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        Set<String> set = vocab.keySet();

        for (String key : set) {
            System.out.println(key + " " +  vocab.get(key));
        }

        return "Its all phone numbers";
    }

}
