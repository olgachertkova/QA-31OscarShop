package helpers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

public class MyDataProvider {
    public MyDataProvider() {
    }

    @DataProvider
    public Iterator<Object[]> languageCheck() {
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{"ru", "Выполнить"});
        list.add(new Object[]{"de", "Ausführen"});
        list.add(new Object[]{"en-gb", "Go"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> searchingForExistingProductTest() {
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{"book"});
        list.add(new Object[]{"T-shirt"});
        list.add(new Object[]{"computers"});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> searchingForSpecificItem() {
        List<Object[]> list = new ArrayList();
        list.add(new Object[]{"Reviewing C++"});
        list.add(new Object[]{"The shellcoder's handbook"});
        list.add(new Object[]{"Oscar T-shirt"});
        return list.iterator();
    }
}
