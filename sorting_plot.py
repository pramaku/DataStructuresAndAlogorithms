from random import random
from random import shuffle
import matplotlib.pyplot as plt

merge_sort_count = 0


def bubble_sort(arr):
    n = len(arr)
    count = 0
    for i in range(n):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j + 1]:
                count = count + 1
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return count


def merge_sort(arr, count=0):
    # print 'Splitting ', arr
    global merge_sort_count
    if len(arr) > 1:
        mid = len(arr) // 2
        lefthalf = arr[:mid]
        righthalf = arr[mid:]

        merge_sort(lefthalf, count)
        merge_sort(righthalf, count)

        i = 0
        j = 0
        k = 0
        # print 'before merging - l -> ', lefthalf
        # print 'before merging - r -> ', righthalf
        while i < len(lefthalf) and j < len(righthalf):
            merge_sort_count = merge_sort_count + 1
            if lefthalf[i] <= righthalf[j]:
                arr[k] = lefthalf[i]
                i = i+1
            else:
                arr[k] = righthalf[j]
                j = j+1
            k = k+1

        while i < len(lefthalf):
            merge_sort_count = merge_sort_count + 1
            arr[k] = lefthalf[i]
            i = i+1
            k = k+1

        while j < len(righthalf):
            merge_sort_count = merge_sort_count + 1
            arr[k] = righthalf[j]
            j = j+1
            k = k+1
    # print("Merging ",arr)
    return merge_sort_count


def plot_sort_metric(my_sort=bubble_sort, iterations=100, **args):
    sort_metrics = {}
    global merge_sort_count
    count = 0
    for i in range(5, iterations, 5):
        count = i
        input_data = list(range(0, count))
        shuffle(input_data)
        sort_metrics[count] = my_sort(input_data, **args)
        merge_sort_count = 0
    keys = sort_metrics.keys()
    list(keys).sort()
    # print keys

    arr_len_list = []
    sort_metric = []

    for key in keys:
        # print key , ' -> ', sort_metrics[key]
        arr_len_list.append(key)
        sort_metric.append(sort_metrics[key])
    plt.plot(arr_len_list, sort_metric, label=my_sort.__name__)
    plt.xlabel('input length')
    plt.ylabel('#iterations')
    plt.legend()


if __name__ == '__main__':
    # bubble sort plotting
    plot_sort_metric(my_sort=bubble_sort)
    # merge sort plotting
    plot_sort_metric(my_sort=merge_sort)

    plt.show()
