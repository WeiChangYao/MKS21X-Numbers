public class RationalNumber extends RealNumber
{
  private int numerator, denominator;

  /**Initialize the RationalNumber with the provided values
  *  if the denominator is 0, make the fraction 0/1 instead
  *@param nume the numerator
  *@param deno the denominator
  */
  public RationalNumber(int nume, int deno){
    super(0.0);//this value is ignored! 
    numerator = nume;
    denominator = deno;
    if (deno == 0){
      numerator = 0;
      denominator = 1;
    }
    if (deno < 0){
      numerator = (nume*-1);
      denominator = (deno*-1);
    }
    reduce();
  }

  public double getValue(){
    return ((double) getNumerator() / (double) getDenominator());
  }

  public int getNumerator(){
    return numerator;
  }

  public int getDenominator(){
    return denominator;
  }

  public RationalNumber reciprocal(){
    return new RationalNumber(this.getDenominator(), this.getNumerator());
  }

  public boolean equals(RationalNumber other){
    if ((this.getNumerator() == other.getNumerator()) & (this.getDenominator() == other.getDenominator())){
      return true;
    }
    else {
      return false;
    }
  }


  public String toString(){
    if (denominator == 1){
      return "" + numerator;
    }
    if (numerator == 0){
      return "" + 0;
    }
    else {
      return "" + getNumerator() + "/" + getDenominator();
    }
  }

  private static int gcd(int a, int b){
    while(a!=0 && b!=0) {
     int c = b;
     b = a%b;
     a = c;
     }
  return a+b; 
  }

  /**
  *Divide the numerator and denominator by the GCD
  *This must be used to maintain that all RationalNumbers are
  *reduced after construction.
  */
  private void reduce(){
    if (numerator != 0){
      int common = gcd(Math.abs(numerator), Math.abs(denominator));
      denominator = denominator/common;
      numerator = numerator/common;
    }
  }
  /******************Operations Return a new RationalNumber!!!!****************/
  /**
  *Return a new RationalNumber that is the product of this and the other
  */
  public RationalNumber multiply(RationalNumber other){
    return new RationalNumber((this.getNumerator()*other.getNumerator()),(this.getDenominator()*other.getDenominator()));
  }

  /**
  *Return a new RationalNumber that is the this divided by the other
  */
  public RationalNumber divide(RationalNumber other){
    return new RationalNumber((this.getNumerator()*other.getDenominator()),(this.getDenominator()*other.getNumerator()));
  }

  /**
  *Return a new RationalNumber that is the sum of this and the other
  */
  public RationalNumber add(RationalNumber other){
    int commonD = this.getDenominator()*other.getDenominator();
    int sum = (this.getNumerator()*other.getDenominator() + other.getNumerator()*this.getDenominator());
    return new RationalNumber (sum, commonD);
  }
  /**
  *Return a new RationalNumber that this minus the other
  */
  public RationalNumber subtract(RationalNumber other){
    int commonD = this.getDenominator()*other.getDenominator();
    int dif = (this.getNumerator()*other.getDenominator() - other.getNumerator()*this.getDenominator());
    return new RationalNumber (dif, commonD);
  }
} 
