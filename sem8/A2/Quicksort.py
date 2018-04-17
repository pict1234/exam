import xml.etree.ElementTree as et
import threading

def getdata(f):
    xmltree = et.parse(f)
    root = xmltree.getroot()
    print root.tag
    a = []
    for child in root:
        a.append(int(child.text))
        print child.tag,child.text
    print a
    print
    return a

def partition(a,l,r):
    pivot = a[l]
    i=l+1
    j=r
    while i<=j:
        while i<len(a) and pivot >= a[i]:             
            i+=1
        while pivot < a[j]:
            j-=1
        if i<j:
            a[i],a[j] = a[j],a[i]
    a[j],a[l] = pivot,a[j]
    return j        

def quicksort(a,l,r):
    
    if l<=r:
        mid = partition(a,l,r)
        print threading.current_thread().getName(),"this thread found mid = ",mid
	# quicksort(l,mid-1)
	# quicksort(mid+1,r)
        t1 = threading.Thread(target=quicksort,args=(a,l,mid-1))
        t1.start()
        t2 = threading.Thread(target=quicksort,args=(a,mid+1,r))
        t2.start()
        
        t1.join();
        t2.join();
    return a

if __name__ == "__main__":
	a = getdata('input.xml')
	quicksort(a,0,len(a)-1)
	print "Sorted array:",a


