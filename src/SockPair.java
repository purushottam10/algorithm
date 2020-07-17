 static int sockMerchant(int[] ar) {
        HashSet<Integer> unmatched = new HashSet<>();
        int pairs = 0;
        
        for(int i = 0; i < ar.length; i++) {
        //this check the next color and if that matched it'll remove that color and increse the no of pair 
            if(!unmatched.add(ar[i])) {
                unmatched.remove(ar[i]);
                pairs++;
            }
        }
            return pairs;
    }
    public static void main(String ... arg){
        System.out.println(sockMerchant(new int[]{2,3,3,4,2,1}));
    }
