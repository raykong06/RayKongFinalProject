import java.util.ArrayList;

public class Pizza {
    private boolean tomatoSauce;
    private boolean cheese;
    private boolean pepperoni;
    private boolean pineapple;
    private boolean mushrooms;
    private boolean jalapenos;
    private ArrayList<Boolean> ingredientList;
    private String name;

    public Pizza()
    {
        this(false,false,false,false,false,false);
    }

    public Pizza (boolean tomatoSauce, boolean cheese, boolean pepperoni, boolean pineapple, boolean mushrooms, boolean jalapenos)
    {
        this.tomatoSauce = tomatoSauce;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.pineapple = pineapple;
        this.mushrooms = mushrooms;
        this.jalapenos = jalapenos;

        ingredientList = new ArrayList<Boolean>();
        ingredientList.add(tomatoSauce);
        ingredientList.add(cheese);
        ingredientList.add(pepperoni);
        ingredientList.add(pineapple);
        ingredientList.add(mushrooms);
        ingredientList.add(jalapenos);

        name = "";
    }

    // compares the ingredients of the two pizzas to see if they are equal
    public boolean comparePizza(Pizza pizzaRecipe)
    {
        boolean isEqual = true;

        if (this.tomatoSauce != pizzaRecipe.tomatoSauce || this.cheese != pizzaRecipe.cheese || this.pepperoni != pizzaRecipe.pepperoni ||
                this.pineapple != pizzaRecipe.pineapple || this.mushrooms != pizzaRecipe.mushrooms || this.jalapenos != pizzaRecipe.jalapenos)
        {
            isEqual = false;
        }
        return isEqual;
    }

    public int getNumIngredients()
    {
        int numIngredients = 0;
        for (int i = 0; i < ingredientList.size(); i++)
        {
            if (ingredientList.get(i))
            {
                numIngredients++;
            }
        }
        return numIngredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTomatoSauce() {
        return tomatoSauce;
    }

    public void setTomatoSauce(boolean tomatoSauce) {
        this.tomatoSauce = tomatoSauce;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isPepperoni() {
        return pepperoni;
    }

    public void setPepperoni(boolean pepperoni) {
        this.pepperoni = pepperoni;
    }

    public boolean isPineapple() {
        return pineapple;
    }

    public void setPineapple(boolean pineapple) {
        this.pineapple = pineapple;
    }

    public boolean isMushrooms() {
        return mushrooms;
    }

    public void setMushrooms(boolean mushrooms) {
        this.mushrooms = mushrooms;
    }

    public boolean isJalapenos() {
        return jalapenos;
    }

    public void setJalapenos(boolean jalapenos) {
        this.jalapenos = jalapenos;
    }
}
