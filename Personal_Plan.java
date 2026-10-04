 public class PersonalPlan extends AIModel{ 
   private int promptsRemaining; 

 public PersonalPlan(String modelName,double price,int parameterCount,int contextWindow,int 
promptsRemaining){ 
     super(modelName,price,parameterCount,contextWindow); 
     this.promptsRemaining=promptsRemaining;
      } 
'''
   * Buys additional prompts and increase quota. 
   * Works by adding the given amount to promptsRemaining. 
   * @param amount number of prompts to add 
   * @return confirmation message 
'''
  public String buyPrompts(int amount){ 
     if(amount > 0){ 
         promptsRemaining += amount; 
         return "Successfully purchased " + amount + " prompts."; 
     } else { 
         return "Error: Amount must be positive."; 
     } 
      } 
'''
  * Processes a prompt if quota allows and tokens are valid. 
  * Decrements promptsRemaining if successful. 
  * @param promptText text of the prompt. 
  * @param outputTokens number of ouput tokens requested 
  * @return success or error message 
'''
 @Override 
   public String enterPrompt(String promptText,int outputTokens){ 
       if(promptsRemaining <=0){ 
           return "Error: Monthly quota exhausted."; 
       } 
       if(!calculateTokens(promptText.length(), outputTokens)){ 
           return "Error: Context limit exceeded."; 
       } 
       promptsRemaining--; 
       int expectedTokens = promptText.length() + outputTokens; 
     return "Entered Prompt: " + promptText + 
           "\nExpected Token Usage: " + expectedTokens + 
            "\nRemaining Quota: " + promptsRemaining; 
   } 
'''
    * Displays plan details including remaining prompts. 
    * @return formatted string of plan info 
'''
    @Override 
    public String display(){ 
        return baseDetails()+"\nPrompts Remaining:" +promptsRemaining; 
    } 
  } 
