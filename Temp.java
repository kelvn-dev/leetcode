
class Parent {
    String name = "Parent";

    public Parent() {
        printName();
    }

    public void printName() {
        System.out.println("1. Name in Parent: " + name);
    }
}

class Child extends Parent {
    String name = "Child";

    public Child() {
        System.out.println("2. Child Constructor finished");
    }

    @Override
    public void printName() {
        System.out.println("3. Name in Child: " + name);
    }
}


class ParentExample {
    public static void main(String[] args) {
        Parent obj = new Child();
        System.out.println("4. Reference name: " + obj.name);
    }
}
