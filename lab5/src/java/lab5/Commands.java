package lab5;

import lab5.exceptions.*;
import lab5.inputters.*;
import lab5.memory.OverflowChecker;
import lab5.memory.historyWork;
import lab5.setterrs.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.AccessException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class Commands {
    private static ArrayList<Integer> ids = new ArrayList<Integer>();

    public static String open(String filename) {
        try (InputStream is = new FileInputStream(filename)) {
            try (BufferedInputStream bis = new BufferedInputStream(is)) {
                ByteArrayOutputStream buf = new ByteArrayOutputStream();
                int result = bis.read();
                while (result != -1) {
                    buf.write((byte) result);
                    result = bis.read();
                }
                return buf.toString().replace("\"", "");
            } catch (Exception e) {
                System.out.println("no such file");
                return "";
            }
        } catch (AccessException e ){
            System.out.println("no access");
            return "";
        }
        catch (Exception e) {
            //System.out.println("s");
            System.out.println("file not found ");
            return ""; // ?????????
        }
    }

    public static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }


    public static Worker upload(String[] sts) throws InvalidDataException, ParseException {
        Worker bum = new Worker();
        String name = sts[0].trim();
        String x = sts[1].trim();
        String y = sts[2].trim();
        String salary = sts[3].trim();
        String startDate = sts[4].trim();
        String endDate = sts[5].trim();
        String birthday = sts[6].trim();
        String height = sts[7].trim();
        String weight = sts[8].trim();
        try {
            String pos = sts[9].trim();
            try {
                SetPosition.setPosition(pos, bum);
            } catch (EmptyStringException e) {
                System.out.println("не удалось установить должность у элемента  " + name + " " + e.getMessage());
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Не указана должность у " + name);
        }
        try {
            SetName.setname(name, bum);
        } catch (EmptyStringException e) {
            System.out.println("не удалось установить имя у элемента  " + name + " " + e.getMessage());
        }

        try {
            SetCordinates.setcordinates(x, y, bum);
        } catch (InvalidCoordinatesException | NumberFormatException e) {
            System.out.println("не удалось координаты у элемента  " + name + " " + e.getMessage());
        }

        try {
            SetSalary.setSalary(salary, bum);
        } catch (InvalidSalaryException | NumberFormatException e) {
            System.out.println("не удалось установить зарплату у элемента  " + name + " " + e.getMessage());
        }


        try {
            SetData.setStartData(startDate, bum);
        } catch (InvalidDataException | ParseException e) {
            System.out.println("не удалось установить дату старта у элемента " + name + " " + e.getMessage());
        }

        try {
            SetData.setEndData(endDate, bum);
        } catch (InvalidDataException | ParseException e) {
            System.out.println("не удалось установить дату конца у элемента " + name + " " + e.getMessage());
        }

        Person person = new Person();
        try {
            SetPersParams.setBirthday(birthday, person);
        } catch (InvalidDataException e) {
            System.out.println("не удалось установить день варенья у элемента " + name + " " + e.getMessage());
        }

        try {
            SetPersParams.setHeight(height, person);
        } catch (EmptyStringException e) {
            System.out.println("не удалось установить рост у элемента  " + name + " " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("not a number");
        }

        try {
            SetPersParams.setWeight(weight, person);
        } catch (EmptyStringException e) {
            System.out.println("не удалось установить вес у элемента  " + name + " " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("not a number");
        }

        bum.setPerson(person);
        return bum;
    }

    public static void help(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        System.out.println(open("Commands.txt"));
    }


    public static void begin(String start, LinkedHashSet<Worker> set) {
        Worker worker = new Worker();
        String[] str = start.split("\r\n");
        for (int i = 1; i < str.length; i++) {
            String[] stats = str[i].split(";");
            try {
                worker = Commands.upload(stats);
                worker = makeId(worker);
                set.add(worker);
            } catch (InvalidDataException | ParseException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public static ArrayList<Integer> getIds() {
        return ids;
    }

    public static void exit(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        System.out.println("bye");
        System.exit(0);
    }

    public static void info(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        Iterator<Worker> it = set.iterator();
        Worker p1 = it.next();
        System.out.println("Type - Worker");
        System.out.println("Created date - " + p1.getCreationDate());
    }

    private static void updateAll(Worker bum) throws IOException {
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        boolean c;
        String input = "";
        while (input.isEmpty()) {
            System.out.print("write name: ");
            input = bufferedReader.readLine().trim();
            if (input.isEmpty()) {
                System.out.println("try again string is empty ");
            }

        }
        bum.setName(input);
        Coordinates cord = new Coordinates();
        long x = inputLong("(int) x");
        int y = inputInt("(long) y");

        Float salary = inputFloat("(float) salary");
        bum.setSalary(salary);
        cord.setXY(x, y);
        bum.setCoordinates(cord);

        Date startDate = inputData("(date) start date");
        bum.setStartDate(startDate);
        Date endDate = inputData("(date) end date");
        bum.setEndDate(endDate);

        Person pers = new Person();
        ZonedDateTime birthday = inputZonedDate("(date) birthday");
        pers.setBirthday(birthday);

        Float height = inputFloat("(float) height");
        pers.setHeight(height);
        Float weight = inputFloat("(float) weight");
        pers.setWeight(weight);

        bum.setPerson(pers);

        boolean c1 = true;

        while (c1) {
            System.out.print("write position: ");
            input = bufferedReader.readLine();
            try {
                SetPosition.setPosition(input, bum);
                c1 = false;

            }
            catch (NullPointerException | NoSuchElementException e) {
                funExit();
            }catch (Exception e) {
                System.out.println(" No such enum");
            }

        }

    }

    public static void add(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();

        updateAll(bum);
        bum = makeId(bum);
        set.add(bum);
    }

    private static long inputLong(String name) {
        LongInputer inputer = new LongInputer();
        return inputer.inputValue(name);
    }

    private static ZonedDateTime inputZonedDate(String name) {
        ZonedDateInputer inputer = new ZonedDateInputer();
        return inputer.inputValue(name);
    }

    private static Date inputData(String name) {
        Datainputer inputer = new Datainputer();
        return inputer.inputValue(name);
    }

    private static int inputInt(String name) {
        IntInputer inputer = new IntInputer();
        return inputer.inputValue(name);
    }

    private static Float inputFloat(String name) {
        FloatInputer inputer = new FloatInputer();
        return inputer.inputValue(name);
    }

    public static void show(List<String> params, LinkedHashSet<Worker> set) throws EmptyCollectionException {
        ParamsChecker.checkParams(0, params);
        if (set.size() == 0) {
            throw new EmptyCollectionException();
        }
        Iterator<Worker> it = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            Worker p1 = it.next();
            System.out.println("чел " + p1.getId() + " и звать его " + p1.getName());
        }
    }

    public static void update(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(1, params);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            Integer s = null;
            String v;
            s = bum.getId();
            v = Integer.toString(s);
            if (v.equals(params.get(0))) {
                updateAll(bum);
                return;
            }
        }
    }

    public static void history(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        ArrayList<String> history = historyWork.getHistory();
        if (history.size() == 0) {
            System.out.print("cant be first command");
        } else {
            for (String s : history) {
                System.out.print(s + " ");
            }
        }
        System.out.println("");
    }

    public static void add_if_min(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        ParamsChecker.checkParams(0, params);
        Worker bum = new Worker();
        updateAll(bum);
        if (set.size() == 0) {
            bum = makeId(bum);
            set.add(bum);
        } else {


            Worker min = Collections.min(set);
            if (bum.compareTo(min) > 0) {
                bum = makeId(bum);
                set.add(bum);
                System.out.println("success");
            } else {
                System.out.println("not min element");
            }
        }
    }

    public static void remove_by_id(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(1, params);
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            Integer s = null;
            String v;
            s = bum.getId();
            v = Integer.toString(s);
            System.out.println(v);
            if (v.equals(params.get(0))) {
                set.remove(bum);
                return;
            }
        }
    }

    public static void clear(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        set.clear();
    }

    public static Worker makeId(Worker bum) {
        bum.setId(ids.size() + 1);
        ids.add(ids.size() + 1);
        return bum;
    }

    public static void save(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        try {
        OutputStream outputStream = new FileOutputStream("save.csv");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("name;x;y;salary;startDate;endDate;birthday;height;weight;position\r\n");
        ParamsChecker.checkParams(0, params);
        Iterator<Worker> it1 = set.iterator();
        String pattern = "dd.MM.yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        DateFormat df = new SimpleDateFormat(pattern);
        while (it1.hasNext()) {
            Worker bum = it1.next();
            System.out.println(bum.toString());
            outputStreamWriter.write(bum.toString());
            //outputStreamWriter.write((bum.getName()+";"+Long.toString(bum.getCoordinates().getX())+";"+Integer.toString(bum.getCoordinates().getY())+";"+Float.toString(bum.getSalary())+";"+df.format(bum.getStartDate())+";"+df.format(bum.getEndDate())+";"+bum.getPerson().getBirthday().format(formatter)+";"+Float.toString(bum.getPerson().getHeight())+";"+Float.toString(bum.getPerson().getWeight())+";"+bum.getPosition().toString())+"\r\n");
        }
        outputStreamWriter.close();}
        catch (AccessException e){
        System.out.println("no access");}
    }


    public static void remove_lower(List<String> params, LinkedHashSet<Worker> set) throws EmptyCollectionException {
        ParamsChecker.checkParams(0, params);
        if (set.size() == 0) {
            throw new EmptyCollectionException();
        }
        Worker min = Collections.min(set);
        set.remove(min);
    }

    public static void remove_all_by_end_date(List<String> params, LinkedHashSet<Worker> set) throws InvalidDateFormatException, ParseException {
        ParamsChecker.checkParams(1, params);
        String input = params.get(0);
        Iterator<Worker> it = set.iterator();
        Worker test = new Worker();
        try {
            SetData.setEndData(input, test);
            while (it.hasNext()) {
                Worker bum = it.next();
                if (bum.getEndDate().compareTo(test.getEndDate()) == 0) {
                    System.out.println("remove " + bum.getName());
                    set.remove(bum);
                    return;
                }
            }
            System.out.println("no equals data");
        } catch (InvalidDateFormatException e) {
            System.out.println(e.getMessage());
        } catch (ParseException e) {
            System.out.println("ошибка парсера");
        }
    }

    public static void filter_by_salary(List<String> params, LinkedHashSet<Worker> set) throws InvalidSalaryException {
        ParamsChecker.checkParams(1, params);
        String salary = params.get(0);
        Iterator<Worker> it = set.iterator();
        Worker test = new Worker();
        try {
            SetSalary.setSalary(salary, test);
            while (it.hasNext()) {
                Worker bum = it.next();
                if (bum.getSalary() == test.getSalary()) {
                    System.out.println(bum.toString());
                    System.out.println("чел " + bum.getId() + " " + bum.getName() + " зарабатывает " + bum.getSalary());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void print_field_descending_end_date(List<String> params, LinkedHashSet<Worker> set) {
        ParamsChecker.checkParams(0, params);
        List<Date> dates = new ArrayList<Date>();
        Iterator<Worker> it = set.iterator();
        while (it.hasNext()) {
            Worker bum = it.next();
            dates.add(bum.getEndDate());

        }
        Collections.sort(dates);
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i));
        }
    }

    public static void execute_script(List<String> params, LinkedHashSet<Worker> set) throws IOException {
        String s = "";
        ParamsChecker.checkParams(1, params);
        s = open(params.get(0));
        if (s.isEmpty()) {
            return;
        }
        OverflowChecker.checkRec(params.get(0));
        String[] commands = s.split("\r\n");
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            System.out.println("doing " + command);
            runCommandFromString(set, command);
        }
    }

    static void runCommandFromString(LinkedHashSet<Worker> workers, String input) {
        try {
            String[] items = input.split(" ");
            String cmd = items[0].toLowerCase();
            List<String> params = new ArrayList<>();
            for (int i = 1; i < items.length; i++) {
                params.add(items[i]);
            }

            try {
                Method method = Commands.class.getMethod(cmd, List.class, LinkedHashSet.class);
                method.invoke(null, params, workers);
                historyWork.historyAdd(cmd);
            } catch (InvocationTargetException e) {
                System.out.println(e.getCause().getMessage());
            } catch (NoSuchMethodException e) {
                System.out.println("no such command");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }catch (NullPointerException | NoSuchElementException e){
                funExit();
            }

            catch (Exception e) {
                e.printStackTrace();
            }
        } catch (NullPointerException | NoSuchElementException e) {
            funExit();
        }
    }
    public static void funExit(){
        System.out.println("не пытайтесь так сломать прогу");
        System.out.println(" +\"\"\"\"\"+ ");
        System.out.println("[| o o |]");
        System.out.println(" |  ^  | ");
        System.out.println(" | '-' | ");
        System.out.println(" +-----+ ");
        System.exit(1);
    }

}


