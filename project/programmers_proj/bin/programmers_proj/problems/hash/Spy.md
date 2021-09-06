```c++
void pick(int n, vector<int>& picked, int toPick){ 
    // 기저 사례 : 더 고를 원소가 없을 떄 고른 원소들을 출력한다. 
    if (toPick == 0) {
        printPicked(picked);
        return;
    } 
    // 고를 수 있는 가장 작은 번호를 계산한다.
    int smallest = picked.empty() ? 0 : picked.back() + 1; 
    // 이 단계에서 원소 하나를 고른다. 
    for (int next = smallest; next < n; ++next) {
        picked.push_back(next); 
        pick(n, picked, toPick - 1); 
        picked.pop_back(); 
    } 
}
```