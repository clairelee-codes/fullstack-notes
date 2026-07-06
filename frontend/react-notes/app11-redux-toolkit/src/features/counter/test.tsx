import React, { useEffect } from "react"
import { useAppDispatch } from "../../app/hooks"
import { fetchUsersAsynce, incrementAsync } from "./counterSlice"

const Test = () => {
  const dispatch = useAppDispatch()

  useEffect(() => {
    const promise = dispatch(fetchUsersAsynce())
    // const promise = dispatch(incrementAsync(10))
    return () => {
      // thunk 실행 중에 중지
      promise.abort()
    }
  }, [])

  return <div>test</div>
}

export default Test
