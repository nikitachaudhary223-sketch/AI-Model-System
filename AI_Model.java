 public abstract class AIModel 
  { 
    private String modelName; 
    private double price; 
    private int parameterCount; 
    private int contextWindow; 
 '''
  * Constructor for AIModel 
  * @param modelName name of the AIModel 
  * @param price subscription price 
  * @param parameterCount number of parameters(in billions) 
  * @param contextWindow context window size 
'''
 public AIModel(String modelName,double price,int parameterCount,int contextWindow){ 
     this.modelName=modelName; 
     this.price=price; 
     this.parameterCount=parameterCount; 
     this.contextWindow=contextWindow; 
 } 
 //accessors 
21. 21. public String getModelName(){return modelName;} 
22. 22. public double getPrice(){return price;} 
23. 23. public int getParameterCount(){return parameterCount;} 
24. 24. public int getContextWindow(){return contextWindow;} 
'''
* Checks if the given input/output tokens fit within the context window. 
* @param inputTokens number of input tokens 
* @param outputTokens number of output tokens 
* @return true if valid,otherwise false 
'''
 public boolean calculateTokens(int inputTokens,int outputTokens){ 
     int systemTokens=50; 
     int totalTokens=inputTokens + outputTokens + systemTokens; 
    return totalTokens <=contextWindow; 
 } 
//abstract method to display plan details 
public abstract String display(); 
//abstract method to process a prompt 
public abstract String enterPrompt(String promptText, int outputTokens); 
   
 protected String baseDetails(){ 
     return "Model Name:" +modelName + 
     "\nPrice(NPR per 1 Lakh tokens):" + price + 
     "\nParameters(billions):" + parameterCount + 
     "\nContext window:" + contextWindow 
 } 
     }