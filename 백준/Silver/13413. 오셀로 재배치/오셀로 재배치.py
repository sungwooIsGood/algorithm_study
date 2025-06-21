test_case = int(input())

for _ in range(test_case):
    n = int(input())
    first_list = list(input())
    second_list = list(input())

    w_to_b = 0  # W → B로 바꿔야 할 개수
    b_to_w = 0  # B → W로 바꿔야 할 개수

    for i in range(n):
        if first_list[i] != second_list[i]:
            if first_list[i] == 'W':
                w_to_b += 1
            else:
                b_to_w += 1

    # 교환 가능한 만큼은 한 번에 처리 가능, 나머지는 뒤집기 필요
    swaps = min(w_to_b, b_to_w)
    flips = abs(w_to_b - b_to_w)

    print(swaps + flips)