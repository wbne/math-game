public class Question
{
    int value; char answer; String question, choices;
    public Question(String q, char a, int v, String c)
    {
        question = q; answer = a; value = v; choices = c;
    }
    
    public void print()
    {
        System.out.println(question);
        System.out.println(choices);
    }
    
}
