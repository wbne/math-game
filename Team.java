public class Team
{
    String name; int points;
    public Team(String name)
    {
        this.name = name;
        points = 0;
    }
    
    public void isCorrect(Question q, char input)
    {
        if(q.answer == input)
            addPoints(q);
        else
            System.out.println("Oh no! " + this.name + " got it incorrect! The answer was: " + q.answer);
    }
    
    public void addPoints(Question q)
    {
        points += q.value;
        System.out.println(this.name + " got the questions correct!");
        System.out.println(this.name + " recieved " + q.value + " points.");
    }
}
