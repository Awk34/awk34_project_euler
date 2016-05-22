/*
 * Andrew Koroluk
 */

public class euler31 {
	static int[] S = {1,2,5,10,20,50,100,200};
	public static void main(String[] args) {
		System.out.println(count(200, 7));
	}
	static int count(int n, int m) {
		if(n==0)
			return 1;
		else if(n<0)
			return 0;
		else if(m<0 && n>=1)
			return 0;
		return count(n,m-1)+count(n-S[m],m);
	}
}
/*
func count( n, m )
initialize table with base cases

for i from 0 to n
  for j from 0 to m
    table[ i, j ] = table[ i - S_j, j ] + table[ i, j - 1 ]

return table[ n, m ]
********************************************************************
def count( n, m ):
    if n == 0:
        return 1
    if n < 0:
        return 0
    if m < 0 and n >= 1:
        return 0
 
    return count( n, m - 1 ) + count( n - S[m], m )
*/