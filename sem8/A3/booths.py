from bitstring import BitArray

def booth(m, r):
	x=8
	y=8
	# Initialize
	totalLength = x + y + 1
	mA = BitArray(int = m, length = totalLength) #2 00000000000000010
	rA = BitArray(int = r, length = totalLength)
	A = mA << (y+1)#2 = 00000010000000000#
	S = BitArray(int = -m, length = totalLength) << (y+1)#subtractor
	P = BitArray(int = r, length = y)
	P.prepend(BitArray(int = 0, length = x))#this is Q in AQQ-1
	P = P << 1
	print "Initial values"
	print "A", A.bin
	print "S", S.bin
	print "P", P.bin
	print "Starting calculation"
	for i in range(1,y+1):
		if P[-2:] == '0b01':
			P = BitArray(int = P.int + A.int, length = totalLength)
			print "P +  A:", P.bin
		elif P[-2:] == '0b10':
			P = BitArray(int = P.int +S.int, length = totalLength)#a=a-m
			print "P +  S:", P.bin
		P = arith_shift_right(P, 1)
		print "P >> 1:", P.bin
	P = arith_shift_right(P, 1)
	print "P >> 1:", P.bin
	return P.int

def arith_shift_right(x, amt):
	l = x.len
	x = BitArray(int = (x.int >> amt), length = l)
	return x

