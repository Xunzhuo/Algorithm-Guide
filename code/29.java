class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==0&&popped.length==0)

        {
            return true;

        }

        if(pushed.length!=popped.length)

        {
            return false;

        }

        Stack<Integer> stack = new Stack<Integer>();

        int i=0,j=0;

        while(i<pushed.length)

        {
            if(stack.isEmpty())

            {
                stack.push(pushed[i++]);

            }

            if(stack.peek()==popped[j])

            {
                stack.pop();

                j++;

            }

            else

            {
                if(i>0&&popped[j]==pushed[i-1])

                {
                    j++;

                    stack.pop();

                }

                else if(i<=pushed.length-1)

                {
                    stack.push(pushed[i++]);

                }

                else

                {
                    return false;

                }

            }

        }

        while(j<popped.length)

        {
            if(popped[j]==stack.peek())

            {
                j++;

                stack.pop();

            }

            else{
                return false;

            }

        }

        return true;

    }

}