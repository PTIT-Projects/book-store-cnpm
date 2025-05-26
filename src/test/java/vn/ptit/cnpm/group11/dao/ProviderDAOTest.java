package vn.ptit.cnpm.group11.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import vn.ptit.cnpm.group11.model.Provider;

import java.util.ArrayList;

public class ProviderDAOTest {
    private final ProviderDAO providerDAO;

    public ProviderDAOTest() {
        this.providerDAO = new ProviderDAO();
    }
    @Test
    public void testSearchProviderStandard() {
        String keyword = "B";
        ArrayList<Provider> results = providerDAO.searchProviderByName(keyword);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(4, results.size());
        for (Provider provider : results) {
            Assertions.assertTrue(provider.getName().toLowerCase().contains(keyword.toLowerCase()));
        }
        for (Provider provider : results) {
            Assertions.assertNotEquals(4, provider.getId());
        }
    }
    @Test
    public void testSearchProviderException() {
        String keyword = "xxx";
        ArrayList<Provider> results = providerDAO.searchProviderByName(keyword);
        Assertions.assertNotNull(results);
        Assertions.assertEquals(0, results.size());
    }

    @Test
    public void testAddProviderStandard() throws Exception {
        Provider provider = new Provider();
        String key = "Test";
        provider.setName(key);
        provider.setAddress("Địa chỉ test");
        provider.setEmail("Email test");
        provider.setPhoneNumber("123");
        boolean isAdded = providerDAO.addNewProvider(provider);
        Assertions.assertTrue(isAdded);

        isAdded = false;
        ArrayList<Provider> providers = providerDAO.searchProviderByName(key);
        for (Provider x : providers) {
            if (x.equals(provider)) {
                isAdded = true;
                break;
            }
        }
        Assertions.assertTrue(isAdded);
    }

    @Test
    public void testAddProviderException1() {
        Provider provider = new Provider();
        provider.setName("An B");
        provider.setAddress("Thanh Xuân, Hà Nội");
        provider.setEmail("nccanb@gmail.com");
        provider.setPhoneNumber("0912834162");
        provider.setNote("Chuyên cung cấp truyện tranh");
        Assertions.assertThrowsExactly(Exception.class, () ->{
            providerDAO.addNewProvider(provider);
        }, "Nhà cung cấp đã tồn tại!");
    }
    @Test
    public void testAddProviderException2() throws Exception {
        Provider provider = new Provider();
        provider.setName("Test 2 lần liên tục");
        provider.setAddress("Địa chỉ test");
        provider.setEmail("Email test");
        provider.setPhoneNumber("123");
        boolean isAdded = providerDAO.addNewProvider(provider);
        Assertions.assertTrue(isAdded);
        Provider provider1 = new Provider();
        provider1.setName("Test 2 lần liên tục");
        provider1.setAddress("Địa chỉ test");
        provider1.setEmail("Email test");
        provider1.setPhoneNumber("123");
        Assertions.assertThrowsExactly(Exception.class, () ->{
            providerDAO.addNewProvider(provider1);
        }, "Nhà cung cấp đã tồn tại!");
    }
}
