import java.util.Scanner;
import java.io.File;
public class Runner
{
    public static void main(String []args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        Scanner sct = new Scanner(new File("questionBank.txt"));

        System.out.println("How many teams are competing?");
        int amt = sc.nextInt();
        sc.nextLine();

        Team[] teams = new Team[amt];
        for(int i = 0; i < amt; i++)
        {
            System.out.println("What is this team's name?");
            teams[i] = new Team(sc.nextLine());
        }

        Question[] questions = new Question[10];
        for(int i = 0; i < questions.length; i++)
        {
            String s1 = "";
            while(true)
            {
                String temp = sct.nextLine();
                if(temp.equals("potato"))
                    break;
                s1 += temp + "\n";
            }
            String s2 = sct.nextLine();
            int p = sct.nextInt();
            char a = sct.nextLine().charAt(1);
            questions[i] = new Question(s1, a, p, s2);
        }

        showScores(teams);
        System.out.println("There will be 10 questions that get progressively harder as this game continues.");
        System.out.println("At the moment, the range is from Algebra I to Calculus III");
        System.out.println("To answer a question, put the team NUMBER in first and then their answer. Eg. 1A or 1a");
        Thread.sleep(10000);
        System.out.print("\f");

        for(int i = 0; i < questions.length; i++)
        {
            questions[i].print();
            String meme = sc.nextLine();
            int tnum = Integer.parseInt(meme.substring(0,1));
            char ans = (char)meme.toLowerCase().charAt(1);
            teams[tnum - 1].isCorrect(questions[i], ans);
            showScores(teams);
            Thread.sleep(7000);
            System.out.print("\f");
        }

        int topChicken = 0;
        for(int i = 1; i < teams.length; i++)
            topChicken = (teams[topChicken].points < teams[i].points) ? i : topChicken;

        System.out.println("And the winner is " + teams[topChicken].name + " with a score of: " + teams[topChicken].points + " points");
        showScores(teams);
    }

    private static void showScores(Team[] teams)
    {
        System.out.println("Here are the current standings");
        for(int i = 0; i < teams.length; i++)
            System.out.println((i + 1) + " " + teams[i].name + ":\t" + teams[i].points + " points");
    }
}
