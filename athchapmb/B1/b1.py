import json
import unittest

class myTestCases(unittest.TestCase):
	def test_positive(self):
		self.assertEqual(run("inp2.json"),True)
	def test_negative(self):
		self.assertEqual(run("inp3.json"),False)

def isattack(board,r,c):
	for i in range(r):
		if (board[i][c] == 1):
			return True

	i = r-1
	j = c-1

	while i>=0 and j>=0:
		if (board[i][j] == 1):			
			return True

		i=i-1
		j=j-1

	i= r-1
	j = c+1

	while i>=0 and j<8:
		if (board[i][j] == 1):			
			return True
 		i=i-1
		j=j+1
	return False


def solve(board,row):
	i=0
	while i<8:
		if (not isattack(board,row,i)):
			board[row][i] = 1

			if row == 7:
				return True
			else:
				if (solve(board,row+1)):
					return True
				else:
					board[row][i] = 0

		i=i+1 #he pahilya if sathiahe

	if i ==8:
		return False


def run(filename):
	board = [[0 for x in range(8)] for x in range(8)]

	if __name__ == '__main__':
		data = []
		with open (filename,'r') as f:
			data = json.load(f)

		if data["start"]>7 or data["start"]<0 :
		 	print 'Invalid input'
			return False

		board[0][data["start"]] =1 #he chukala board = [0][data["start"]] asa lihila

		if solve(board,1):#he visarlo
			print 'board config\n'
			for i in range(8):
				for j in range(8):
					print str(board[i][j])+' ',#use of comma
				print "\n"

			return True
 		else:
  			 print "8 Queens not solved"
	
run('inp1.json')
print'-----------------Testing-----------------'
unittest.main()






















