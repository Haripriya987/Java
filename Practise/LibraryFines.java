class LibraryFines{
  public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
    if (y1 > y2) {
        return 10000;
    } else if (y1 < y2) {
        return 0;
    } else if (m1 > m2) {
        return (m1 - m2) * 500;
    } else if (m1 < m2) {
        return 0;
    } else if (d1 > d2) {
        return (d1 - d2) * 15;
    } else {
        return 0;
    }
    }
  
public static void main(String args[]){

  int res= libraryFine(2,8,18,3,9,18);
  System.out.println(res);
  }
  }
  
