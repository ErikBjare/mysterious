int main() {
    int p = 2;
    while(p<100) {
        if(isPrime(p) == 1) {
            print(p);
        } else {
            //print(0 - p);
        }
        p = p + 1;
    }
    return 0;
}
int isPrime(int p) {
    int i = 2;
    while(i<p) {
        if(p%i == 0) {
            return 0;
        }
        i = i + 1;
    }
    return 1;
}
