import numpy as np
#一維距離 絕對值相減
def dis(a, b):
    return abs(a-b)
def do_kmeans(k, area_list, centroids):
    loss = 0
    groups = []
    new_centroids = []
    for i in range(k):
        groups.append([])
        new_centroids.append(0)
    print(centroids)
    for area in area_list:
        #最小距離
        min_distance = 999999
        group_index = 0
        for centroid_index, centroid in enumerate(centroids):
            #每項跟質點的距離
            distance = dis(area, centroid)
            #假設 質點距離小於目前最小距離則寫入
            if distance < min_distance:
                min_distance = distance
                group_index = centroid_index
                #print("distance",distance,"centroid_index",centroid_index)
        #將質點編號和
        print("groups[{group_index]",groups[group_index],"area",area)
        groups[group_index].append(area)
        loss += min_distance
        new_centroids[group_index] += area
    print(groups)    
    for i in range(k):
        #沒假設底數為0情況會報錯
        #計算每個每個質點群的平均 ex: 質點[503, 1, 502] 群:[[503], [1, 2, 3, 4, 50, 51, 52, 53], [500, 501, 502]] 平均:[503.0, 27.0, 501.0]
        new_centroids[i] = new_centroids[i]/len(groups[i])if len(groups[i]) != 0 else 0
    #回傳新質點
    return new_centroids, groups, loss
def compute_centroids(D, k, loss_convergence, iterations_num):
    area_list = D
    #隨機選質點
    centroid_indices = np.random.choice(len(area_list), k)
    centroids = []
    
    for centroid_index in centroid_indices:
        centroids.append(area_list[centroid_index])
    print("centroids",centroids)
    #第一次
    centroids, groups, old_loss = do_kmeans(k, area_list, centroids)
    iterations = 1
    i = 0
    while True:
        i = 1+i
        centroids, groups, loss = do_kmeans(k, area_list, centroids)
        iterations = iterations + 1
        print("number:", i, "loss = %f" % loss)
        #假設不在收束 或是 超過跌代次數
        if abs(old_loss - loss) < loss_convergence or iterations > iterations_num:
            break
        old_loss = loss
        for centroid in centroids:
            print(centroid)
    # print result
    j = 0
    groups_list = []
    for centroid in centroids:
        print(centroid, "numbers:", len(groups[j]))
        groups_list.append(len(groups[j]))
        j = j+1
    print(sorted(groups))
D = [1,501,502,503,2,3,4,50,51,52,53,500]
k = 3
loss_convergence = 1e-10
iterations_num = 500
compute_centroids(D, k, loss_convergence,  iterations_num)