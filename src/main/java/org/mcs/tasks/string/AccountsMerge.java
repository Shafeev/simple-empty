package org.mcs.tasks.string;

import java.util.*;

/**
 * Дан список аккаунтов, где каждый элемент accounts[i] - это список строк, где первый элемент accounts[i][0] - это имя,
 * а остальные элементы - это электронные адреса, представляющие электронную почту аккаунта.
 *
 * Теперь мы хотели бы объединить эти счета. Два аккаунта определенно принадлежат одному и тому же человеку,
 * если у обоих аккаунтов есть какая-то общая электронная почта. Обратите внимание, что даже если два аккаунта имеют
 * одинаковое имя, они могут принадлежать разным людям, так как люди могут иметь одинаковые имена. Изначально человек
 * может иметь любое количество счетов, но все его счета обязательно имеют одно и то же имя.
 *
 * После объединения счетов верните счета в следующем формате: первым элементом каждого аккаунта является имя,
 * а остальные элементы - это электронные письма в отсортированном порядке. Сами счета могут быть возвращены в любом
 * порядке.
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],
 * ["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],
 * ["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],
 * ["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],
 * ["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],
 * ["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 */
public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();

        List<String> acc1 = new ArrayList<>();
        acc1.add("John");
        acc1.add("johnsmith@mail.com");
        acc1.add("john_newyork@mail.com");

        List<String> acc2 = new ArrayList<>();
        acc2.add("John");
        acc2.add("johnsmith@mail.com");
        acc2.add("john00@mail.com");

        List<String> acc3 = new ArrayList<>();
        acc3.add("Mary");
        acc3.add("mary@mail.com");


        List<String> acc4 = new ArrayList<>();
        acc4.add("John");
        acc4.add("johnnybravo@mail.com");

        accounts.add(acc1);
        accounts.add(acc2);
        accounts.add(acc3);
        accounts.add(acc4);

        System.out.println(accountsMerge(accounts));

    }

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<Account> accList = new ArrayList<>();

        for (List<String> account : accounts) {
            String name = account.get(0);
            Account acc = new Account(name, account.subList(1, account.size()));
            boolean isFind = false;
            for (Account oldAcc : accList) {
                for(String email : account.subList(1, account.size())) {
                    if (oldAcc.emails.contains(email)) {
                        oldAcc.emails.addAll(account.subList(1, account.size()));
                        isFind = true;
                        break;
                    }

                }
            }
            if (!isFind) {
                accList.add(acc);
            }
        }


        List<List<String>> result = new ArrayList<>();
        for (Account account : accList) {
            List<String> acc = new ArrayList<>();
            acc.add(account.name);
            acc.addAll(account.emails);
            result.add(acc);
        }

        return result;
    }

    private static class Account {
        String name;
        TreeSet<String> emails = new TreeSet<>();

        Account(String name, List<String> emailList) {
            this.name = name;
            emails.addAll(emailList);
        }

    }
}
